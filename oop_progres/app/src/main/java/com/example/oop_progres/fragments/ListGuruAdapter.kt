package com.example.oop_progres.fragments


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_progres.R
import com.example.oop_progres.fragments.guru_fragment.ListDirections
import com.example.oop_progres.model.Guru
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlin.collections.List

class ListGuruAdapter: RecyclerView.Adapter<ListGuruAdapter.GuruViewHolder>() {

    private var guruList = emptyList<Guru>()

    class GuruViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListGuruAdapter.GuruViewHolder {
        return GuruViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return guruList.size
    }

    override fun onBindViewHolder(holder: ListGuruAdapter.GuruViewHolder, position: Int) {
        val currentItem = guruList[position]
        holder.itemView.hasil_id.text = currentItem.id.toString()
        holder.itemView.hasil_nama.text = currentItem.nama.toString()
        holder.itemView.hasil_mapel.text = currentItem.mapel.toString()

        holder.itemView.rowGuru.setOnClickListener {
            val action = ListDirections.actionList2ToUpdateGuru(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }
    fun setData(guru: List<Guru>){
        this.guruList = guru
        notifyDataSetChanged()
    }


}
