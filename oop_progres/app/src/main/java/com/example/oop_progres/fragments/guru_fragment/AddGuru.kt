package com.example.oop_progres.fragments.guru_fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.oop_progres.R
import com.example.oop_progres.model.Guru
import com.example.oop_progres.modelview.GuruModelView
import kotlinx.android.synthetic.main.fragment_add_guru.*
import kotlinx.android.synthetic.main.fragment_add_guru.view.*


class AddGuru : Fragment() {
    private lateinit var mGuruModelView: GuruModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_guru, container, false)
        mGuruModelView = ViewModelProvider(this).get(GuruModelView::class.java)

        view.btn_add.setOnClickListener {
            insertToDatabase()
        }
        return view
    }
    private fun insertToDatabase(){
        val nama = txt_nama.text.toString()
        val mapel = txt_mapel.text.toString()

        if(inputCheck(nama,mapel)){
            val guru = Guru(0, nama, mapel)
            mGuruModelView.addGuru(guru)
            Toast.makeText(requireContext(), "Berhasil Menambahkan Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addGuru_to_list2)
        }else{
            Toast.makeText(requireContext(), "Gagal Menambahkan Data!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(nama:String, mapel:String):Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(mapel))

    }


}