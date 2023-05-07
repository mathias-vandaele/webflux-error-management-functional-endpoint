package dev.mathiasvandaele.errormanagement.errorsmanagement;

import dev.mathiasvandaele.errormanagement.dto.BusinessError;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class BusinessException extends RuntimeException implements Error {

    private final Integer code;
    private final String message;
    private final String advice;

    public BusinessException(Integer code, String message, String advice) {
        super(message);
        this.code = code;
        this.message = message;
        this.advice = advice;
    }

    @Override
    public Mono<ServerResponse> getAsServerResponse() {
        return ServerResponse.badRequest().bodyValue(this.createBusinessErrorMessage());
    }

    private BusinessError createBusinessErrorMessage() {
        return BusinessError.builder()
                .message(this.message)
                .advice(this.advice)
                .code(this.code)
                .build();
    }

}
