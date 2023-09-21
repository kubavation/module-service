package com.durys.jakub.moduleservice.modules

import com.durys.jakub.moduleservice.events.Events
import com.durys.jakub.moduleservice.events.model.ModuleShortcutChangedEvent
import org.bouncycastle.util.Objects
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class ModuleService(private val moduleRepository: ModuleRepository,
                             private val events: Events) {

    fun findAll() = moduleRepository.findAll()

    fun edit(moduleShortcut: String, module: Module): Mono<Module> {

       return moduleRepository.findById(moduleShortcut)
               .map { of(it) }
               .doOnSuccess { events.emit(ModuleShortcutChangedEvent(moduleShortcut, it.shortcut)) }
               .onErrorComplete()
    }


    fun of(module: Module): Module = Module(module.shortcut, module.name, module.description)
}