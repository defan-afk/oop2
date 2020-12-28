package com.example.oop_progres.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.oop_progres.R
import com.example.oop_progres.model.Siswa
import com.example.oop_progres.modelview.SiswaModelView
import kotlinx.android.synthetic.main.fragment_update_guru.view.*
import kotlinx.android.synthetic.main.fragment_update_siswa.*
import kotlinx.android.synthetic.main.fragment_update_siswa.view.*

class UpdateSiswa : Fragment() {

    private val args1 by navArgs<UpdateSiswaArgs>()

    private lateinit var mSiswaModelView: SiswaModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_siswa, container, false)
        mSiswaModelView = ViewModelProvider(this).get(SiswaModelView::class.java)

        view.update_nama_siswa.setText(args1.currentSiswa.nama)
        view.update_alamat.setText(args1.currentSiswa.alamat)

        view.btn_ubah1.setOnClickListener {
            updateSiswa()
        }
        setHasOptionsMenu(true)

        return view
    }

    private fun updateSiswa() {
        val nama = update_nama_siswa.text.toString()
        val alamat = update_alamat.text.toString()

        if (inputCheck1(nama, alamat)) {

            val updateSiswa = Siswa(args1.currentSiswa.id, nama, alamat)
            mSiswaModelView.updateSiswa(updateSiswa)
            Toast.makeText(requireContext(), "Berhasil Mengubah Data!!!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateSiswa_to_list_Siswa)
        } else {
            Toast.makeText(requireContext(), "Gagal Mengubah Data!!!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck1(nama: String, alamat: String): Boolean {
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat))
    }

    override fun onCreateOptionsMenu(menu1: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu1)
    }

    override fun onOptionsItemSelected(item1: MenuItem): Boolean {
        if (item1.itemId == R.id.menu_hapus) {
            deleteSiswa()
        }
        return super.onOptionsItemSelected(item1)
    }

    private fun deleteSiswa() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Ya") { _, _ ->
            mSiswaModelView.deleteSiswa(args1.currentSiswa)
            Toast.makeText(
                requireContext(),
                "Berhasil Menghapus Data: ${args1.currentSiswa.nama}",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_updateSiswa_to_list_Siswa)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Hapus ${args1.currentSiswa.nama}?")
        builder.setMessage("Apakah yakin akan menghapus ${args1.currentSiswa.nama}?")
        builder.create().show()
    }

}