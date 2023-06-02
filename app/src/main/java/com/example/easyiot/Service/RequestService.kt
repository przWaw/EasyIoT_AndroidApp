package com.example.easyiot.Service

import com.example.easyiot.Model.FileDescription
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface RequestService {

    suspend fun getScripts(): List<FileDescription>
    suspend fun getHostName(): String


    companion object {
        fun create(): RequestService {
            return RequestServiceImpl(
                client = HttpClient(Android) {
                    install(ContentNegotiation){
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        })
                    }
                    install(Logging){
                        level = LogLevel.ALL
                    }
                }
            )
        }
    }
}
