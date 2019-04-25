package quiz.service;

import org.slf4j.Logger;

import lombok.AllArgsConstructor;
import quiz.accessor.QuestionBankAccessor;
import quiz.model.QuestionBank;
import quiz.model.User;
import quiz.model.enums.QuestionBankType;

@AllArgsConstructor
public class QuestionBankService {

    QuestionBankAccessor questionBankAccessor;

    public QuestionBank getQuestionBank(User user) throws Exception {
        //add functionalities;
        Logger
        return questionBankAccessor.getAnyQuestionBank();
    }

    public QuestionBank getQuestionBankById(Long id) throws Exception {
        //add functionalities;
        return questionBankAccessor.getQuestionBankbyId(id);
    }

    public QuestionBank getQuestionBankwithType(User user, QuestionBankType type) throws Exception {
        //add functionalities;
        return questionBankAccessor.getAnyQuestionBank();
    }
}
