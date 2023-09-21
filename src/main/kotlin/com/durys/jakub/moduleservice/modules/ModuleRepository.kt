package com.durys.jakub.moduleservice.modules

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

internal interface ModuleRepository: ReactiveMongoRepository<Module, String>