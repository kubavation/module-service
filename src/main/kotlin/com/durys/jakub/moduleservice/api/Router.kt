package com.durys.jakub.moduleservice.api

import com.durys.jakub.moduleservice.modules.ModuleHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router


@Configuration
internal class Router {

    @Bean
    fun routes(handler: ModuleHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api/modules".nest {
                GET("", handler::modules)
                GET("/{moduleShortcut}/config", handler::moduleUrl)
                PUT("/{moduleShortcut}", handler::edit)
            }
        }

    }

}