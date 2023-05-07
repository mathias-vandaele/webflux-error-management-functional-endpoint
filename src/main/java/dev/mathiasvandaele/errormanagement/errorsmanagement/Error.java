package dev.mathiasvandaele.errormanagement.errorsmanagement;

import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface Error {

    Mono<ServerResponse> getAsServerResponse();
}
