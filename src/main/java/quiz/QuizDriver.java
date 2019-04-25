package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import quiz.accessor.QuestionBankAccessor;
import quiz.accessor.QuizAccessor;
import quiz.accessor.UserAccessor;
import quiz.model.Question;
import quiz.model.QuestionBank;
import quiz.model.Quiz;
import quiz.model.User;
import quiz.model.enums.QuestionBankType;
import quiz.requests.CalculateScoreRequest;
import quiz.service.QuestionBankService;
import quiz.service.QuizService;

public class QuizDriver {
    public static void main(String[] args) {
        UserAccessor userAccessor = new UserAccessor();
        User user = new User(1l, "aman", 0l);
        userAccessor.setUsers(Arrays.asList(user));

        List<String> options = new ArrayList<>();
        options.add("2");
        options.add("1");
        options.add("4");
        options.add("3");

        Question question1 = new Question(1l, "1+2", options, "3");
        Question question2 = new Question(2l, "1+3", options, "4");
        Question question3 = new Question(3l, "0+1", options, "1");
        Question question4 = new Question(4l, "1+1", options, "2");
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        QuestionBank questionBank = new QuestionBank(1l, questions, QuestionBankType.EASY, "Maths Quiz");
        QuestionBankAccessor questionBankAccessor = new QuestionBankAccessor();
        questionBankAccessor.setQuestionBanks(Arrays.asList(questionBank));


        QuestionBankService questionBankService = new QuestionBankService(questionBankAccessor);
        QuizAccessor quizAccessor = new QuizAccessor();
        // init complete
        QuizService quizService = new QuizService(userAccessor, quizAccessor, questionBankService);

        Scanner sc = new Scanner(System.in);
        int cmdinput = 1;


        try {
            System.out.println("Enter USER Name");
            String name = sc.nextLine();
            User playUser = userAccessor.getUserbyName(name);
            Long userId = playUser.getId();

            while (cmdinput != 0) {
                System.out.println("1: Play quiz ");
                System.out.println("2: Get User Score ");
                System.out.println("3: Play already taken Quiz");
                System.out.println("0: exit ");
                cmdinput = sc.nextInt();


                if (cmdinput == 1) {
                    QuestionBank qb = quizService.getQuiz(userId);
                    playQuiz(quizService, sc, userId, qb);
                } else if (cmdinput == 2) {
                    System.out.println("User Latest score : " + playUser.getLatestScore() + "\n");
                } else if (cmdinput == 3) {
                    List<Quiz> quizList = quizService.getAllPastQuiz(userId);
                    System.out.println("\n select from the list to retake\n");
                    for (int i = 0; i < quizList.size(); i++) {
                        System.out.println((i+1) + quizList.get(i).getQuestionBank().getName());
                    }
                    int qbnext = sc.nextInt();
                    playQuiz(quizService, sc, userId, quizList.get(qbnext-1).getQuestionBank());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thanks Ta Ta : Bye ");


    }

    private static void playQuiz(QuizService quizService, Scanner sc, Long userId, QuestionBank qb) throws Exception {
        CalculateScoreRequest request = new CalculateScoreRequest();
        request.setUserId(userId);
        request.setQuestionBankId(qb.getId());
        Map<Long, String> answers = new HashMap<>();
        for (Question question : qb.getQuestions()) {
            System.out.println("Question: " + question.getQuestion()
                                   + "\n" + "options: ");
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println(i + 1 + ": " + question.getOptions().get(i));
            }

            System.out.println("choose one option from  above: ");
            Integer answer = sc.nextInt();
            System.out.println("\n");

            answers.put(question.getId(), question.getOptions().get(answer - 1));
        }
        request.setAnswers(answers);

        System.out.println("User scored : " + quizService.calculateScore(request) + "\n");
    }

//    public static void setUsers(){
//
//    }
}
