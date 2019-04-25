package quiz.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import quiz.model.enums.QuestionBankType;

@Data
@AllArgsConstructor
public class QuestionBank {
    private Long id;
    private Set<Question> questions;
    private QuestionBankType type;
    private String name;

}
