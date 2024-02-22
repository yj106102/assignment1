package study.assignment1.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiResult> exceptionHandler(ResponseStatusException e) {

        return new ResponseEntity<ApiResult>(new ApiResult(e.getReason(), null), e.getStatusCode());
    }
}
