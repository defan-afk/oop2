package com.example.oop_progres.fragments.guru_fragment

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
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            deleteAllGuru()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllGuru() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mGuruModelView.deleteAllGuru()
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