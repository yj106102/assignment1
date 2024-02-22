package study.assignment1.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ApiResponseEntity extends ResponseEntity<ApiResult> {
    public ApiResponseEntity(String message, Object body, HttpStatusCode httpStatusCode) {
        super(new ApiResult(message, body), httpStatusCode);
    }
    public ApiResponseEntity(String message, Object body) {
        this(message,body, HttpStatus.OK);
    }

    public ApiResponseEntity(String message) {
        this(message,null);
    }
}
