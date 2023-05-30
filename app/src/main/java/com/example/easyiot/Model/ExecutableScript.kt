package com.example.easyiot.Model

import kotlinx.serialization.Serializable

@Serializable
data class ExecutableScript(
    val scriptName: String?,
    val arguments: List<String>?
)
