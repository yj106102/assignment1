package study.assignment1.Utils;

import org.springframework.http.HttpStatusCode;

public class ExceptionMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public ExceptionMessage(String message) {
        this.message = message;
    }
}
