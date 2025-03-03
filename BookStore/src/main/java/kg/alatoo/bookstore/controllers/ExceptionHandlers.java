package kg.alatoo.bookstore.controllers;

import jakarta.validation.ValidationException;
import kg.alatoo.bookstore.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {


    //TODO: when we put exception handler in controller advice class,
    // the exception does not returns body that provided in exception handler,
    // but when our exception handler inside a controller it works properly
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> handleNotFound(NotFoundException ex) {
        log.debug("Handling NotFoundException");
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());
        responseBody.put("status", 404);
        responseBody.put("timestamp", System.currentTimeMillis());
        return responseBody;
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity <?> handleValidationException(ValidationException ex) {
        log.debug("Handling ValidationException");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <?> handleNotValidDataException(MethodArgumentNotValidException ex) {
        log.debug("Handling MethodArgumentNotValidException");
        List<Object> errors = Collections.singletonList(ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::toString).toList());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
