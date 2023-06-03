package com.example.easyiot.Model

import kotlinx.serialization.Serializable


@Serializable
data class FileDescription (
    val scriptName: String?,
    val inputType: InputType?,
    val requestType: RequestType?,
    var arguments: List<String>?,
    val description: String?
)

