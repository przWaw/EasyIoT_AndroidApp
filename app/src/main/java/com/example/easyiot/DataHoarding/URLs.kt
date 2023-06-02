package com.example.easyiot.DataHoarding

object URLs {
    const val baseHttp = "http://"
    const val api = "/api/easyIoT"
    const val port = ":8080"
    var ip = ""
        set(value) {
            field = value
            getScripts = "$baseHttp$ip$port$api/scripts"
            getHostName = "$baseHttp$ip$port$api/hostname"
        }
    var getScripts = ""
    var getHostName = ""
}