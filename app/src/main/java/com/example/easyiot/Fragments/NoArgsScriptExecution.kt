package com.example.easyiot.Fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.Model.ExecutableScript
import com.example.easyiot.Model.ScriptOutput
import com.example.easyiot.R
import com.example.easyiot.Service.RequestService
import kotlinx.coroutines.launch
import java.lang.Exception

class NoArgsScriptExecution : Fragment() {
    private lateinit var service: RequestService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        service = RequestService.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_no_args_script_execution, container, false)
        var output: ScriptOutput
        val text = view.findViewById<TextView>(R.id.outputText)
        val outputView = view.findViewById<CardView>(R.id.outputView)
        val button = view.findViewById<Button>(R.id.executeButton)
        button.setOnClickListener{
            lifecycleScope.launch {
                try {
                    val chosenScript = AvailableScripts.chosenScript
                    val script = ExecutableScript(chosenScript.scriptName, chosenScript.arguments?.toMutableList())
                    output = service.executeScript(script)
                    readOutput(output, text, outputView)
                } catch (e: Exception) {
                    Toast.makeText(context, getString(R.string.unable_to_connect), Toast.LENGTH_SHORT).show()
                    Log.e("REQUEST_ERROR", e.message.toString())
                }
            }
        }

        return view
    }

    private fun readOutput(output: ScriptOutput, text: TextView, outputView: CardView) {
        if (!output.errorMessage.isNullOrEmpty()) {
            text.text = output.errorMessage.joinToString(separator = "\n")
            outputView.setBackgroundColor(Color.RED)
            text.gravity = Gravity.START
            text.setTextColor(Color.WHITE)
            text.textSize = 20f
        } else {
            text.text = output.outputMessage!!.joinToString(separator = "\n")
            outputView.setBackgroundColor(Color.GREEN)
            text.setTextColor(Color.WHITE)
        }
    }

}