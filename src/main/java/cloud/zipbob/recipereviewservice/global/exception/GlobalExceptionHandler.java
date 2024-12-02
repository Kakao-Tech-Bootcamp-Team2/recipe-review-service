package cloud.zipbob.recipereviewservice.global.exception;

import cloud.zipbob.recipereviewservice.global.ErrorResponse;
import cloud.zipbob.recipereviewservice.global.Responder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseEx(BaseException exception) {
        String errorCode = exception.getExceptionType().getErrorCode();
        String errorMessage = exception.getExceptionType().getErrorMessage();
        log.error("BaseException errorCode() : {}", errorCode);
        log.error("BaseException errorMessage() : {}", errorMessage);
        return Responder.error(errorCode, errorMessage, exception.getExceptionType().getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error("Validation error: {}", errors);
        String formattedErrorMessage = errors.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
        return Responder.error("V001", formattedErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleEx(Exception e) {
        log.error(e.getMessage(), e);
        return Responder.error("S001", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
