package in.codingstreams.etbffservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.servlet.support.BindStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    INVALID_SIGN_UP_REQUEST("A400","Invalid Sign Up Request!"),
    INVALID_LOGIN_REQUEST("A400","Invalid Login  Request!"),
    INVALID_CHANGE_PASSWORD_REQUEST("A400","Invalid Change Password Request!"),
    INVALID_UPDATE_REQUEST("A400","Invalid  Update Request!"),
    INVALID_EXPENSE_REQUEST("A400","Invalid  Expense  Request!"),
    INVALID_DATE_RANGE("A400","Invalid  Date  Range!");


    private String errorCode;
    private String errorMessage;
}
