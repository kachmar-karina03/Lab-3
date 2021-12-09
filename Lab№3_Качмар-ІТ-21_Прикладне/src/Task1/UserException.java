package Task1;

import java.util.List;

public class UserException extends RuntimeException {
    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public UserException(final List<String> messages) {
        super(messages.toString());
    }

    public UserException(final List<String> messages, final ErrorCode errorCode) {
        super(messages.toString());
        this.errorCode = errorCode;
    }

}