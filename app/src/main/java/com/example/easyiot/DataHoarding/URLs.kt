package com.example.easyiot.DataHoarding

object URLs {
    private const val baseHttp = "http://"
    private const val api = "/api/easyIoT"
    private const val port = ":8080"
    var ip = ""
        set(value) {
            field = value
            getScripts = "$baseHttp$ip$port$api/scripts"
            getHostName = "$baseHttp$ip$port$api/hostname"
            executScript = "$baseHttp$ip$port$api/exec/simple"
        }
    var getScripts = ""
    var getHostName = ""
    var executScript = ""
}