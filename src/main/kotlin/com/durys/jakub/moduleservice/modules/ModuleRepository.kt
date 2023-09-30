package com.durys.jakub.moduleservice.modules

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

internal interface ModuleRepository: ReactiveMongoRepository<Module, String> {

    fun findByShortcut(shortcut: String): Mono<Module>;
}