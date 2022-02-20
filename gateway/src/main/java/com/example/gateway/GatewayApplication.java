package com.example.gateway;

import com.example.gateway.myribbion.FluxHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder locatorBuilder) {

        return locatorBuilder.routes()
                .route(p ->
                        p.path("/xxoo")
                                .filters(f -> f.stripPrefix(1))
                                .uri("http://www.baidu.com")
                )

                .route(p ->

                        p.path("/go")
                                .filters(f -> f.stripPrefix(1))
                                .uri("lb://MDB")
                )

                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> function(FluxHandler fluxHandler){

        RouterFunction<ServerResponse> route = RouterFunctions.route(

                RequestPredicates.path("/002"),
                req -> ServerResponse.ok().body(BodyInserters.fromValue("web router function")))


                .andRoute(RequestPredicates.GET("/003"), fluxHandler::get003);


        return route;


    }

}
