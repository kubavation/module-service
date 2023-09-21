package com.durys.jakub.moduleservice.modules

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
internal class ModuleHandler(val moduleRepository: ModuleRepository) {

    fun modules(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(moduleRepository.findAll(), Module::class.java);
    }

    fun edit(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(moduleRepository.findAll(), Module::class.java);
    }

}