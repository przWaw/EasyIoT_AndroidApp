package com.example.easyiot.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.easyiot.DataHoarding.AvailableScripts
import com.example.easyiot.R
import com.example.easyiot.databinding.FragmentHelloBinding



class HelloFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHelloBinding>(inflater,
            R.layout.fragment_hello,container,false)
        binding.numberOfAvailableScripts.text = AvailableScripts.scripts.size.toString()
        return binding.root
    }

}