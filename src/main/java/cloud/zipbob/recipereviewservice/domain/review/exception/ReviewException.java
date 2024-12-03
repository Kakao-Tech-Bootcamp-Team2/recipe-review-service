package cloud.zipbob.recipereviewservice.domain.review.exception;

import cloud.zipbob.recipereviewservice.global.exception.BaseException;
import cloud.zipbob.recipereviewservice.global.exception.BaseExceptionType;

public class ReviewException extends BaseException {
    private final BaseExceptionType exceptionType;

    public ReviewException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return this.exceptionType;
    }
}
