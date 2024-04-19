package com.example.nbc_standard_4_week.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.presentation.viewholder.Card1ViewHolder
import com.example.nbc_standard_4_week.presentation.viewholder.Card2ViewHolder
import com.example.nbc_standard_4_week.presentation.viewholder.Card3ViewHolder
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.data.ViewType
import com.example.nbc_standard_4_week.data.dataList
import com.example.nbc_standard_4_week.databinding.ItemCard1Binding
import com.example.nbc_standard_4_week.databinding.ItemCard2Binding
import com.example.nbc_standard_4_week.databinding.ItemCard3Binding

class DataAdapter(private val data: MutableList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick{
        fun onClick(view:View, position: Int)
    }
    var itemClick: ItemClick? = null


    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> ViewType.CARD1.viewType
            1 -> ViewType.CARD2.viewType
            2 -> ViewType.CARD3.viewType
            else -> throw IllegalAccessException("Invalid position")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val view: View?
        return when (viewType) { //todo sealed class -> else 제거해보기
            ViewType.CARD1.viewType-> {
                val binding = ItemCard1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card1ViewHolder(binding)
            }

            ViewType.CARD2.viewType -> {
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
        when (holder.itemViewType) {
            ViewType.CARD1.viewType -> {
                (holder as Card1ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }
            }

            ViewType.CARD2.viewType -> {
                (holder as Card2ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }
            }

            ViewType.CARD3.viewType -> {
                (holder as Card3ViewHolder).bind(data[position])
                holder.setIsRecyclable(false)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it,position)
                }
            }
        }
    }

}

