package com.durys.jakub.moduleservice.api

import com.durys.jakub.moduleservice.modules.ModuleHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
internal class Router {

    @Bean
    fun routes(handler: ModuleHandler): RouterFunction<ServerResponse> {
        return route(GET("/api/modules").and(accept(MediaType.APPLICATION_JSON)), handler::modules)
                .andRoute(PUT("/api/modules/{moduleShortcut}").and(accept(MediaType.APPLICATION_JSON)), handler::edit)
    }

}