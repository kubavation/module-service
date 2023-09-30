package com.durys.jakub.moduleservice.modules

import com.durys.jakub.moduleservice.modules.config.ModuleConfigurationService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
internal class ModuleHandler(val moduleService: ModuleService, val moduleConfigurationService: ModuleConfigurationService) {

    fun modules(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(moduleService.findAll(), Module::class.java);
    }

    fun moduleUrl(request: ServerRequest): Mono<ServerResponse> = ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(moduleConfigurationService.moduleUrl(request.pathVariable("moduleShortcut")))

    fun edit(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(moduleService.edit(request.pathVariable("moduleShortcut"), request.bodyToMono(Module::class.java)), Module::class.java);
    }

}