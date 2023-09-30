package com.durys.jakub.moduleservice.modules

import com.durys.jakub.moduleservice.events.Events
import com.durys.jakub.moduleservice.events.model.ModuleShortcutChangedEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class ModuleService(private val moduleRepository: ModuleRepository,
                             private val events: Events) {

    fun findAll() = moduleRepository.findAll()

    fun edit(moduleShortcut: String, module: Mono<Module>): Mono<Module> {

       return moduleRepository.findByShortcut(moduleShortcut)
               .zipWith(module)
               .map { of(it.t2) } //todo
               .doOnSuccess { events.emit(ModuleShortcutChangedEvent(moduleShortcut, it.shortcut)) }
               .onErrorComplete()
    }


    fun of(module: Module): Module = Module(module.shortcut, module.name, module.description)
}