package com.example.easyiot.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.DataHoarding.URLs
import com.example.easyiot.Model.FileDescription
import com.example.easyiot.R
import com.example.easyiot.Service.RequestService
import kotlinx.coroutines.launch
import java.lang.Exception


class ConnectActivity : AppCompatActivity() {

    private val service = RequestService.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connect_point)
        val inputBox: EditText = findViewById(R.id.IpAddressInput)
        findViewById<Button>(R.id.ConnectButton).setOnClickListener{
            URLs.ip = inputBox.text.toString()
            lifecycleScope.launch {
                try {
                    AvailableScripts.scripts = service.getScripts()
                    val goToNextActivity =
                        Intent(applicationContext, ScriptExecutionActivity::class.java)
                    startActivity(goToNextActivity)
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, getString(R.string.unable_to_connect), Toast.LENGTH_SHORT).show()
                    Log.e("REQUEST_ERROR", e.message.toString())
                    AvailableScripts.scripts = emptyList()
                }
            }
        }
    }
}
