package com.example.oop_progres.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_progres.R
import com.example.oop_progres.fragments.guru_fragment.ListDirections
import com.example.oop_progres.fragments.siswa_fragment.List_SiswaDirections
import com.example.oop_progres.model.Siswa
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.customrow_siswa.view.*

class ListSiswaAdapter: RecyclerView.Adapter<ListSiswaAdapter.SiswaViewHolder>(){

    private var siswaList = emptyList<Siswa>()

    class SiswaViewHolder(itemView1: View): RecyclerView.ViewHolder(itemView1) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaViewHolder {
        return SiswaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customrow_siswa, parent, false))
    }

    override fun getItemCount(): Int {
        return siswaList.size
    }

    override fun onBindViewHolder(holder: SiswaViewHolder, position: Int) {
        val currentItem1 = siswaList[position]
        holder.itemView.hasil_id_siswa.text = currentItem1.id.toString()
        holder.itemView.hasil_nama_siswa.text = currentItem1.nama
        holder.itemView.hasil_alamat.text = currentItem1.alamat

        holder.itemView.rowSiswa.setOnClickListener {
            val action1 = List_SiswaDirections.actionListSiswaToUpdateSiswa(currentItem1)
            holder.itemView.findNavController().navigate(action1)
        }
    }
    fun setDataSiswa(siswa: List<Siswa>){
        this.siswaList = siswa
        notifyDataSetChanged()
    }
}