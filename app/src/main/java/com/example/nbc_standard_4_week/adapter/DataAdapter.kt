package com.example.nbc_standard_4_week.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.adapter.viewholder.Card1ViewHolder
import com.example.nbc_standard_4_week.adapter.viewholder.Card2ViewHolder
import com.example.nbc_standard_4_week.adapter.viewholder.Card3ViewHolder
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.data.item_card1
import com.example.nbc_standard_4_week.data.item_card2
import com.example.nbc_standard_4_week.data.item_card3
import com.example.nbc_standard_4_week.databinding.ItemCard1Binding
import com.example.nbc_standard_4_week.databinding.ItemCard2Binding
import com.example.nbc_standard_4_week.databinding.ItemCard3Binding

class DataAdapter(private val data: MutableList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    interface ItemClick{
        fun onClick(view:View, position: Int)
    }
    var itemClick:ItemClick? = null


    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) { //todo sealed class -> else 제거해보기
            item_card1 -> {
                val binding = ItemCard1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card1ViewHolder(binding)
            }

            item_card2 -> {
                val binding = ItemCard2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card2ViewHolder(binding)
            }

            else -> { //item_card3
                val binding = ItemCard3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card3ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (data[position].type) {
            item_card1 -> {
                (holder as Card1ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }


            }

            item_card2 -> {
                (holder as Card2ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }
            }

            else -> { //item_card3
                (holder as Card3ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }
            }
        }
    }

}

