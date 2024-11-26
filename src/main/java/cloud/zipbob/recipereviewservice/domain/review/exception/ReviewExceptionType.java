package cloud.zipbob.recipereviewservice.domain.review.exception;

import cloud.zipbob.recipereviewservice.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum ReviewExceptionType implements BaseExceptionType {
    REVIEW_NOT_FOUND("RV001", "해당 리뷰는 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    REVIEW_NOT_FOUND_FOR_RECIPE("RV002", "해당 레시피에 리뷰는 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    REVIEW_NOT_FOUND_FOR_MEMBER("RV003", "해당 사용자의 리뷰는 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    REVIEW_ALREADY_EXIST("RV004", "이미 해당 리뷰가 존재합니다.", HttpStatus.CONFLICT);

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    ReviewExceptionType(String errorCode, String errorMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
