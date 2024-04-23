package com.example.nbc_standard_4_week.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.databinding.ItemCard1Binding
import java.text.DecimalFormat
//다른 데이터 구조일 경우도 있을까봐 만들었습니다.

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