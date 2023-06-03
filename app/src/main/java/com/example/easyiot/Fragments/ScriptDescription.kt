package com.example.easyiot.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.R

class ScriptDescription : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_script_description, container, false)
        val text = view.findViewById<TextView>(R.id.description)
        text.text = AvailableScripts.chosenScript.description ?: "You have to chose script first"
        return view
    }

}