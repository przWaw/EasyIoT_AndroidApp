package com.example.easyiot.Model

import kotlinx.serialization.Serializable


@Serializable
data class ScriptOutput (
     val outputMessage: List<String>?,
     val errorMessage: List<String>?,
)