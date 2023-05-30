package com.example.easyiot.DataHoarding

object URLs {
    const val baseHttp = "http://"
    const val api = "/api/easyIoT"
    const val port = ":8080"
    var ip = "192.168.100.76"
        set(value) {
            field = value
            getScripts = "$baseHttp$ip$port$api/scripts"
        }
    var getScripts = ""
}