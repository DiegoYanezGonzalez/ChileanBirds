package com.example.chileanbirds.bird.lista.domain.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.chileanbirds.bird.lista.domain.model.Ave
import com.example.chileanbirds.databinding.AvesItemBinding
import com.squareup.picasso.Picasso

class AvesViewHolder (itemView : View, private val avesItemClickListener: AvesItemClickListener) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
            Picasso.get().load(ave.images?.url).into(binding.ivImageAve)
            tvName.text= ave.name?.spanish
            cvItemAves.setOnClickListener{
                avesItemClickListener.onAvesItemClickListener(ave)
            }

        }


    }
}