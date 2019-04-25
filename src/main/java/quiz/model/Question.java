package quiz.model;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Question {

    private Long id;
    private String question;
    private List<String> options;
    private String answer;

    public Question(Long id, String question, List<String> options, String answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        if(!options.contains(answer)){
            throw new ExceptionInInitializerError("answer not part of answer");
        }
        this.answer = answer;
    }

}
