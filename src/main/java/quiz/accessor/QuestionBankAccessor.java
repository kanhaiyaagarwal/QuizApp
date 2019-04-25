package quiz.accessor;

import java.util.List;

import quiz.model.QuestionBank;

public class QuestionBankAccessor {

    private static QuestionBankAccessor accessor;
    private List<QuestionBank> questionBanks;

    public QuestionBankAccessor(){

    }
//
//    public QuestionBankAccessor getInstance(){
//        if(accessor==null){
//            accessor = new QuestionBankAccessor();
//        }
//        return accessor;
//    }


    public QuestionBank getAnyQuestionBank() throws Exception {
        if(questionBanks==null ||questionBanks.isEmpty()){
            throw new Exception("QuestionBank not present");
        }
        return questionBanks.get(0);
    }


    public QuestionBank getQuestionBankbyId(Long id) throws Exception {
        if(questionBanks==null ||questionBanks.isEmpty()){
            throw new Exception("QuestionBank not present");
        }
        for (QuestionBank questionBank : questionBanks){
            if (questionBank.getId()==id)
                return questionBank;
        }
        throw new Exception("QuestionBank not present");
    }

    public QuestionBank getQuestionBankByanem(String name) throws Exception {
        if(questionBanks==null ||questionBanks.isEmpty()){
            throw new Exception("QuestionBank not present");
        }
        for (QuestionBank questionBank : questionBanks){
            if (questionBank.getName().equals(name))
                return questionBank;
        }
        throw new Exception("QuestionBank not present");
    }

    public void setQuestionBanks(List<QuestionBank> questionBanks) {
        this.questionBanks = questionBanks;
    }
}
