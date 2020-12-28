package com.example.oop_progres.fragments.siswa_fragment

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
import com.example.oop_progres.model.Siswa
import com.example.oop_progres.modelview.SiswaModelView
import kotlinx.android.synthetic.main.fragment_add_siswa.*
import kotlinx.android.synthetic.main.fragment_add_siswa.view.*


class AddSiswa : Fragment() {
    private lateinit var mSiswaModelView: SiswaModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_siswa, container, false)
        mSiswaModelView = ViewModelProvider(this).get(SiswaModelView::class.java)

        view.btn_add_siswa.setOnClickListener {
            insertDatabaseSiswa()
        }
        return view
    }
    private fun insertDatabaseSiswa(){
        val nama = txt_nama_siswa.text.toString()
        val alamat = txt_alamat.text.toString()

        if(inputCheckSiswa(nama,alamat)){
            val siswa = Siswa(0, nama, alamat)
            mSiswaModelView.addSiswa(siswa)
            Toast.makeText(requireContext(), "Berhasil Menambahkan Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addSiswa_to_list_Siswa)
        }else{
            Toast.makeText(requireContext(), "Gagal Menambahkan Data!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheckSiswa(nama:String, alamat:String):Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat))

    }


}