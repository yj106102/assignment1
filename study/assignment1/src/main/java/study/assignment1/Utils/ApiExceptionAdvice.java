package study.assignment1.Utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ExceptionMessage> exceptionHandler(ResponseStatusException e) {

        return new ResponseEntity<ExceptionMessage>(new ExceptionMessage(e.getReason()), e.getStatusCode());
    }
}
