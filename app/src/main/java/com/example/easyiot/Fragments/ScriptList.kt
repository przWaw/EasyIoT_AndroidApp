package com.example.easyiot.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyiot.Adapter.RecycleViewInterface
import com.example.easyiot.Adapter.RecyclerViewAdapter
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.Model.FileDescription
import com.example.easyiot.Model.InputType
import com.example.easyiot.R

class ScriptList : Fragment(), RecycleViewInterface {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_script_list, container, false)
        recyclerView = fragmentView.findViewById(R.id.recyclerViewer)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewAdapter(AvailableScripts.scripts, this)
        return fragmentView
    }

    override fun onItemClick(position: Int) {
        changeFragment(AvailableScripts.scripts[position])
//        Toast.makeText(context, "Im clicked on position $position", Toast.LENGTH_SHORT).show()
    }

    private fun changeFragment(script: FileDescription){
        AvailableScripts.chosenScript = script
        val fragment = when(AvailableScripts.chosenScript.inputType){
            InputType.NO_ARGS -> NoArgsScriptExecution()
            else -> ScriptList()
        }
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragmentView, fragment)
            ?.addToBackStack(null)
            ?.commit()

    }

}