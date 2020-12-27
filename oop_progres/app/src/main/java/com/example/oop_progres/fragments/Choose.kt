package com.example.oop_progres.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.oop_progres.R
import kotlinx.android.synthetic.main.fragment_choose.view.*
import kotlinx.android.synthetic.main.fragment_list2.view.*

class Choose : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose, container, false)
        view.btn_guru.setOnClickListener {
            findNavController().navigate(R.id.action_choose_to_list2)
        }
        return view
    }

}