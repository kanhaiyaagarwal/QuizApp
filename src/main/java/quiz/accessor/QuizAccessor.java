package quiz.accessor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import quiz.model.Quiz;
import quiz.model.User;

public class QuizAccessor {

    private Map<Long , List<Quiz>> quizzes;

    public QuizAccessor(){
        quizzes = new HashMap<>();
    }


    public void addQuiz(Long userId, Quiz quiz) {
        List<Quiz> quizlist = quizzes.getOrDefault(userId, new LinkedList<>());
        quizlist.add(quiz);
        quizzes.put(userId, quizlist);
    }

    public List<Quiz> getQuizForUsers(Long userId) {
        return quizzes.getOrDefault(userId, new LinkedList<>());
    }

    public void setQuizzes(Map<Long, List<Quiz>> quizzes) {
        this.quizzes = quizzes;
    }
}
