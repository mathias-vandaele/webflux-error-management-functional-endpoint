package dev.mathiasvandaele.errormanagement.errorsmanagement;

import dev.mathiasvandaele.errormanagement.dto.TechnicalError;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class TechnicalException extends RuntimeException implements Error{

    private final String message;

    public TechnicalException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public Mono<ServerResponse> getAsServerResponse() {
        return ServerResponse.unprocessableEntity().bodyValue(createBusinessErrorMessage());
    }

    private TechnicalError createBusinessErrorMessage() {
        return TechnicalError.builder()
                .message(this.message)
                .build();
    }

}
