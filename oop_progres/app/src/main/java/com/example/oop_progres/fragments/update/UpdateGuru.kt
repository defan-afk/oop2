package com.example.oop_progres.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.oop_progres.R
import com.example.oop_progres.model.Guru
import com.example.oop_progres.modelview.GuruModelView
import kotlinx.android.synthetic.main.fragment_update_guru.*
import kotlinx.android.synthetic.main.fragment_update_guru.view.*

class UpdateGuru : Fragment() {

    private val args by navArgs<UpdateGuruArgs>()
    private lateinit var mGurumodelView: GuruModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_guru, container, false)

        mGurumodelView = ViewModelProvider(this).get(GuruModelView::class.java)

        view.update_nama.setText(args.currentGuru.nama)
        view.update_mapel.setText(args.currentGuru.mapel)

        view.btn_ubah.setOnClickListener {
            updateGuru()
        }

        setHasOptionsMenu(true)

        return view
    }
    private fun updateGuru(){
        val nama = update_nama.text.toString()
        val mapel = update_mapel.text.toString()

        if (inputCheck(nama, mapel)){
            val updateGuru = Guru(args.currentGuru.id, nama, mapel)
            mGurumodelView.updateGuru(updateGuru)
            Toast.makeText(requireContext(), "Berhasil Mengubah Data!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateGuru_to_list2)

        }else{
            Toast.makeText(requireContext(), "Gagal Mengubah Data!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(nama:String, mapel:String):Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(mapel))

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteGuru()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun deleteGuru(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Ya"){ _, _->
            mGurumodelView.deleteGuru(args.currentGuru)
            Toast.makeText(requireContext(),"Berhasil Menghapus Data: ${args.currentGuru.nama}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateGuru_to_list2)
        }
        builder.setNegativeButton("No"){ _, _->}
        builder.setTitle("Hapus ${args.currentGuru.nama}?")
        builder.setMessage("Apakah yakin akan menghapus ${args.currentGuru.nama}?")
        builder.create().show()
    }
}