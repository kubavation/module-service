package com.durys.jakub.moduleservice.modules.config

import com.durys.jakub.moduleservice.modules.ModuleConfig
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.stereotype.Service

@Service
internal class ModuleConfigurationService(val env: Environment) {

    fun moduleUrl(moduleShortcut: String): ModuleConfig = ModuleConfig(env["app-config.${moduleShortcut}.url"])

}