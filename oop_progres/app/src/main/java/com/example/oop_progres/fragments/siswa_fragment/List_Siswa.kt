package com.example.oop_progres.fragments.siswa_fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_progres.R
import com.example.oop_progres.fragments.ListGuruAdapter
import com.example.oop_progres.fragments.ListSiswaAdapter
import com.example.oop_progres.modelview.GuruModelView
import com.example.oop_progres.modelview.SiswaModelView
import kotlinx.android.synthetic.main.fragment_list2.view.*
import kotlinx.android.synthetic.main.fragment_list__siswa.view.*

class List_Siswa : Fragment() {

    private lateinit var mSiswaModelView: SiswaModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list__siswa, container, false)

        val adapter1 = ListSiswaAdapter()
        val recyclerView = view.recycleView1
        recyclerView.adapter = adapter1
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mSiswaModelView = ViewModelProvider(this).get(SiswaModelView::class.java)
        mSiswaModelView.readDataSiswa.observe(viewLifecycleOwner, Observer { siswa ->
            adapter1.setDataSiswa(siswa)
        })

        view.floatingActionButton1.setOnClickListener {
            findNavController().navigate(R.id.action_list_Siswa_to_addSiswa)
        }
        setHasOptionsMenu(true)
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteAllSiswa()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllSiswa() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mSiswaModelView.deleteAllSiswa()
            Toast.makeText(
                requireContext(),
                "Berhasil Menghapus Semua Data",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Menghapus Semua Data")
        builder.setMessage("Apakah yakin akan menghapus semua data?")
        builder.create().show()
    }
}
