package common.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

//    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(createMessage(e, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    public Map<String, Object> createMessage(Throwable e, HttpStatus status) {
        Map<String, Object> errorResponse = new LinkedHashMap<>();

        errorResponse.put("statusCode", status.value());
        errorResponse.put("timestamp", new Date());
        errorResponse.put("error", e.getMessage());

        return errorResponse;
    }
}
