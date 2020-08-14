package nl.aegon.calculator.controller.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IllegalStateExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalStateException.class})
    protected ResponseEntity<Object> handleIllegalState(RuntimeException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
