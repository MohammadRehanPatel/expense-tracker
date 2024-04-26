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
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;

    public void isValid(){
        if(StringUtils.isEmpty(oldPassword)
                || StringUtils.isEmpty(newPassword )
        ){
            throw new InvalidRequestException(
                    ErrorMessage.INVALID_UPDATE_REQUEST.getErrorMessage(),
                    ErrorMessage.INVALID_UPDATE_REQUEST.getErrorCode()
            );
        }
    }

}
