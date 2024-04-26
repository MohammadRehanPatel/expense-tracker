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
public class SignUpRequest {
    private String name;
    private String email;
    private String password;

    public void isValid(){
        if(StringUtils.isEmpty(name)
        || StringUtils.isEmpty(email)
        || StringUtils.isEmpty(password)
        ){
            throw new InvalidRequestException(
                    ErrorMessage.INVALID_SIGN_UP_REQUEST.getErrorMessage(),
                    ErrorMessage.INVALID_SIGN_UP_REQUEST.getErrorCode()
            );
        }
    }

}
