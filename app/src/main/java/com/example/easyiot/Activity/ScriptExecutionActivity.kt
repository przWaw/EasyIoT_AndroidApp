package com.example.easyiot.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.R

class ScriptExecutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script_execution)
        findViewById<TextView>(R.id.listSize).text = AvailableScripts.scripts.size.toString()
    }
}