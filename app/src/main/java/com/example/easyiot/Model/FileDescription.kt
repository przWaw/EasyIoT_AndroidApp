package com.example.easyiot.Model

import kotlinx.serialization.Serializable


@Serializable
data class FileDescription (
    val scriptName: String?,
    val inputType: InputType?,
    val requestType: RequestType?,
    val arguments: List<String>?,
    val description: String?
)

