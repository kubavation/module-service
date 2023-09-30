package com.durys.jakub.moduleservice.modules

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Module(@Id val _id: String?, val shortcut: String, val name: String, val description: String) {

    constructor(shortcut: String, name: String, description: String)
            : this(null, shortcut, name, description)
}