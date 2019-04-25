package quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quiz {
    private Long userId;
    private Long score;
    private QuestionBank questionBank;
}
