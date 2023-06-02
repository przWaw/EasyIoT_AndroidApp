package com.example.easyiot.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.easyiot.Model.FileDescription
import com.example.easyiot.databinding.ScriptListRowBinding


class RecyclerViewAdapter(private val scripts: List<FileDescription>): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(binding: ScriptListRowBinding) : ViewHolder(binding.root){
        val scriptName = binding.scriptName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val scriptListBinding = ScriptListRowBinding.inflate(inflater, parent, false)
        return RecyclerViewHolder(scriptListBinding)
    }

    override fun getItemCount(): Int {
        return scripts.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.scriptName.text = scripts[position].scriptName
    }
}