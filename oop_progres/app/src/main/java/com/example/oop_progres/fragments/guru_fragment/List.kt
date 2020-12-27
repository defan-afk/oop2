package com.example.oop_progres.fragments.guru_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_progres.R
import com.example.oop_progres.fragments.ListGuruAdapter
import com.example.oop_progres.modelview.GuruModelView
import kotlinx.android.synthetic.main.fragment_list2.view.*


class List : Fragment() {
    private lateinit var mGuruModelView: GuruModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list2, container, false)

        val adapter = ListGuruAdapter()
        val recyclerView = view.recycleView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mGuruModelView = ViewModelProvider(this).get(GuruModelView::class.java)
        mGuruModelView.readAllData.observe(viewLifecycleOwner, Observer { guru ->
            adapter.setData(guru)
        })


        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_list2_to_addGuru)
        }
        return view
    }
}

