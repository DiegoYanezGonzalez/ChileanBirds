package com.example.chileanbirds.bird.lista.domain.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chileanbirds.R
import com.example.chileanbirds.bird.lista.domain.model.Ave

class AvesAdapter (
    private val list: List<Ave>, private val avesItemClickListener: AvesItemClickListener
) : RecyclerView.Adapter<AvesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.aves_item, parent, false)
        return AvesViewHolder(view,avesItemClickListener )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AvesViewHolder, position: Int) {
        holder.bind(list[position])
    }
    fun filterAves(filter : String){
        list.filter {
            it.name?.spanish?.contains(filter) ?: false

        }
        notifyDataSetChanged()

    }

}