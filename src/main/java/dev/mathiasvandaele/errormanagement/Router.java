package dev.mathiasvandaele.errormanagement;

import dev.mathiasvandaele.errormanagement.controllers.HelloController;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@AllArgsConstructor
public class Router {

    private final HelloController helloController;

    @Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
        return route(GET("/hello-world/{name}"),
                helloController::execute);
    }

}