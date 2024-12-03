package cloud.zipbob.recipereviewservice.global.exception;

public class CustomAuthenticationException extends BaseException{
    private final BaseExceptionType baseExceptionType;

    public CustomAuthenticationException(BaseExceptionType baseExceptionType) {
        this.baseExceptionType = baseExceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return this.baseExceptionType;
    }
}
