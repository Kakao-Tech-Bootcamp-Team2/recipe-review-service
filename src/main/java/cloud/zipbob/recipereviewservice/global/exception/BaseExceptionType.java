package cloud.zipbob.recipereviewservice.global.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {
    String getErrorCode();

    String getErrorMessage();

    HttpStatus getHttpStatus();
}
