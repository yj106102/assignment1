package study.assignment1.utils;

public class ApiResult {
    private String message;
    private Object data;

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public ApiResult(String message, Object data) {
        this.message = message;
        this.data = data;

    }
}
