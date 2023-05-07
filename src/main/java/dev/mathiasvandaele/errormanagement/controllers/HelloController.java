package dev.mathiasvandaele.errormanagement.controllers;

import dev.mathiasvandaele.errormanagement.dto.DummyReturn;
import dev.mathiasvandaele.errormanagement.errorsmanagement.BusinessException;
import dev.mathiasvandaele.errormanagement.errorsmanagement.TechnicalException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class HelloController {


    public Mono<ServerResponse> execute(ServerRequest request) {
        return Mono
                .fromSupplier(() -> new DummyReturn(request.pathVariable("name")))
                .flatMap( dummyReturn -> ServerResponse.ok().bodyValue(dummyReturn))

                .onErrorResume(BusinessException.class, BusinessException::getAsServerResponse)
                .onErrorResume(TechnicalException.class, TechnicalException::getAsServerResponse);
    }
}
