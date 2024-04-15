package com.example.nbc_standard_4_week.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.databinding.ItemCard2Binding
import java.text.DecimalFormat

class Card2ViewHolder(binding: ItemCard2Binding) : RecyclerView.ViewHolder(binding.root) {
    private val name = binding.tvName
    private val num1 = binding.tvCardNum1
    private val num2 = binding.tvCardNum2
    private val num3 = binding.tvCardNum3
    private val num4 = binding.tvCardNum4
    private val YM = binding.tvYM
    private val price = binding.tvPrice
    fun bind(data: Data) {
        name.text = data.tvName
        num1.text = data.num1.toString()
        num2.text = data.num2.toString()
        num3.text = data.num3.toString()
        num4.text = data.num4.toString()
        YM.text = data.YM
        val decimal = DecimalFormat("#,##,###.00")
        price.text = decimal.format(data.price)
    }
}