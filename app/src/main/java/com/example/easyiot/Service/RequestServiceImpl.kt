package com.example.easyiot.Service

import android.util.Log
import com.example.easyiot.DataHoarding.URLs
import com.example.easyiot.Model.ExecutableScript
import com.example.easyiot.Model.FileDescription
import com.example.easyiot.Model.ScriptOutput
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RequestServiceImpl(private val client: HttpClient) : RequestService {
    override suspend fun getScripts(): List<FileDescription> {
        return try {
            client.get {
                url(URLs.getScripts)
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ClientRequestException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ServerResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: Exception) {
            Log.e("REQUEST_ERROR", e.message.toString())
            throw Exception(e.message.toString())
        }
    }

    override suspend fun getHostName(): String {
        return try {
            client.get {
                url(URLs.getHostName)
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ClientRequestException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ServerResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: Exception) {
            Log.e("REQUEST_ERROR", e.message.toString())
            throw Exception(e.message.toString())
        }
    }


    override suspend fun executeScript(file: ExecutableScript): ScriptOutput {
        return try {
            client.post{
                url(URLs.executScript)
                contentType(ContentType.Application.Json)
                setBody(file)
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ClientRequestException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: ServerResponseException) {
            Log.e("REQUEST_ERROR", e.response.status.description)
            throw Exception(e.response.status.description)
        } catch (e: Exception) {
            Log.e("REQUEST_ERROR", e.message.toString())
            throw Exception(e.message.toString())
        }
    }
}
