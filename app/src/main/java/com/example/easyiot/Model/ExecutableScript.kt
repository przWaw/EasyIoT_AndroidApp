package com.example.easyiot.Model

import kotlinx.serialization.Serializable

@Serializable
data class ExecutableScript(
    val scriptName: String?,
    var arguments: MutableList<String>?
)
