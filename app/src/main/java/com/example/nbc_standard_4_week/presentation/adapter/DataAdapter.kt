package com.example.nbc_standard_4_week.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.presentation.ViewTypeEnum
import com.example.nbc_standard_4_week.databinding.ItemCard1Binding
import com.example.nbc_standard_4_week.databinding.ItemCard2Binding
import com.example.nbc_standard_4_week.databinding.ItemCard3Binding
import com.example.nbc_standard_4_week.databinding.ItemUnknownBinding
import com.example.nbc_standard_4_week.presentation.adapter.viewholder.Card1ViewHolder
import com.example.nbc_standard_4_week.presentation.adapter.viewholder.Card2ViewHolder
import com.example.nbc_standard_4_week.presentation.adapter.viewholder.Card3ViewHolder
import com.example.nbc_standard_4_week.presentation.adapter.viewholder.UnknownViewHolder
import com.example.nbc_standard_4_week.presentation.model.DataModel

class DataAdapter(private val onClick: (DataModel)-> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var dataList = listOf<DataModel>()
//    interface ItemClick{
//        fun onClick(view:View, position: Int)
//    }
//    var itemClick: ItemClick? = null

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type.viewType
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val multiViewTypeEnum = ViewTypeEnum.entries.find { it.viewType == viewType }
        //ViewType.entries: ViewType의 값들이 리스트로 전부 온다.
        return when (multiViewTypeEnum) {
            ViewTypeEnum.CARD1-> {
                val binding = ItemCard1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card1ViewHolder(binding)
            }

            ViewTypeEnum.CARD2 -> {
                val binding = ItemCard2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card2ViewHolder(binding)
            }

            ViewTypeEnum.CARD3 -> { //item_card3
                val binding = ItemCard3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card3ViewHolder(binding)
            }
            else -> {
                val binding = ItemUnknownBinding.inflate(LayoutInflater.from(parent.context),parent, false)
                UnknownViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    //viewHolder와 data 바인딩
    //클릭 이벤트 처리
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = dataList[position]
        when (holder.itemViewType) {
            ViewTypeEnum.CARD1.viewType -> {
                (holder as Card1ViewHolder).bind(currentItem)
                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            ViewTypeEnum.CARD2.viewType -> {
                (holder as Card2ViewHolder).bind(currentItem)
                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            ViewTypeEnum.CARD3.viewType -> {
                (holder as Card3ViewHolder).bind(currentItem)
                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

}

