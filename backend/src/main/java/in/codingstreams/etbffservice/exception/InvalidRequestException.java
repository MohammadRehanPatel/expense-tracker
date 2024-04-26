package in.codingstreams.etbffservice.exception;

import lombok.Getter;

@Getter
public class InvalidRequestException extends RuntimeException {
    private String errorCode;

    public InvalidRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
