package quiz.requests;

import java.util.Map;

import lombok.Data;

@Data
public class CalculateScoreRequest {
    private Long userId;
    private Long questionBankId;
    private Map<Long, String> answers;
}
