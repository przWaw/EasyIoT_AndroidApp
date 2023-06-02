package com.example.easyiot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.easyiot.Model.FileDescription
import com.example.easyiot.databinding.ScriptListRowBinding


class RecyclerViewAdapter(private val scripts: List<FileDescription>, private val recyclerInterface: RecycleViewInterface): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(binding: ScriptListRowBinding, recyclerInterface: RecycleViewInterface) : ViewHolder(binding.root){
        val scriptName = binding.scriptName
        init {
            binding.scriptView.setOnClickListener(){
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    recyclerInterface.onItemClick(position)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val scriptListBinding = ScriptListRowBinding.inflate(inflater, parent, false)
        return RecyclerViewHolder(scriptListBinding, recyclerInterface)
    }

    override fun getItemCount(): Int {
        return scripts.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.scriptName.text = scripts[position].scriptName
    }
}