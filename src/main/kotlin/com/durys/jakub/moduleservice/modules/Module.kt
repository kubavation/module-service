package com.durys.jakub.moduleservice.modules

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Module(@Id val shortcut: String, val name: String, val description: String)