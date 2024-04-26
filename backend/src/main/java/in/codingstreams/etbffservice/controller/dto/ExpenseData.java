package in.codingstreams.etbffservice.controller.dto;

import in.codingstreams.etbffservice.constant.ErrorMessage;
import in.codingstreams.etbffservice.exception.InvalidRequestException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseData {

    private String title;
    private Double amount;
    private String expCatId;

    public void isValid(){
        if(
                StringUtils.isEmpty(title)
                        || (amount <= 0)
                        || StringUtils.isEmpty(expCatId)
        ){
            throw new InvalidRequestException(
                    ErrorMessage.INVALID_EXPENSE_REQUEST.getErrorMessage(),
                    ErrorMessage.INVALID_EXPENSE_REQUEST.getErrorCode()
            );
        }
    }
}
