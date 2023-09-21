package com.durys.jakub.moduleservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ModuleServiceApplication

fun main(args: Array<String>) {
	runApplication<ModuleServiceApplication>(*args)
}