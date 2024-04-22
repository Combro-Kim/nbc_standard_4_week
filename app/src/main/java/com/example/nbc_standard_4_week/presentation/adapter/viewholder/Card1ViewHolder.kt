package com.example.nbc_standard_4_week.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.databinding.ItemCard1Binding
import java.text.DecimalFormat

class Card1ViewHolder(private val binding: ItemCard1Binding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data){
        binding.apply {
            tvName.text = data.tvName
            tvCardNum1.text = data.num1.chunked(4).joinToString(" ")
            tvYM.text = data.YM
            val decimal = DecimalFormat("#,##,###.00")
            tvPrice.text = decimal.format(data.price)
        }
    }
}