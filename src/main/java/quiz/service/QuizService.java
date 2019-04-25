package quiz.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import quiz.accessor.QuizAccessor;
import quiz.accessor.UserAccessor;
import quiz.model.Question;
import quiz.model.QuestionBank;
import quiz.model.Quiz;
import quiz.model.User;
import quiz.requests.CalculateScoreRequest;

@AllArgsConstructor
public class QuizService {
    UserAccessor userAccessor;
    QuizAccessor quizAccessor;
    QuestionBankService questionBankService;

    public QuestionBank getQuiz(Long userId) throws Exception {
        User user = userAccessor.getUser(userId);
        return questionBankService.getQuestionBank(user);
    }

    public Long calculateScore(CalculateScoreRequest request) throws Exception {
        Set<Question> questions = questionBankService.getQuestionBankById(request.getQuestionBankId()).getQuestions();
        Map<Long,String> userAnswers = request.getAnswers();
        Long score = 0l;
        for(Question question : questions){
            if(userAnswers.get(question.getId()).equals(question.getAnswer())){
                score++;
            }
        }
        userAccessor.setUserScore(request.getUserId(), score);
        Quiz quiz = new Quiz(request.getUserId(),score, questionBankService.getQuestionBankById(request.getQuestionBankId()));
        quizAccessor.addQuiz(request.getUserId(), quiz);
        return score;
    }

    public List<Quiz> getAllPastQuiz(Long userId ){
        return quizAccessor.getQuizForUsers(userId);
    }


}
