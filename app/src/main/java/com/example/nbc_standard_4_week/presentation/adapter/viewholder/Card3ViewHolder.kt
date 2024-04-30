package com.example.nbc_standard_4_week.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.data.entity.DataEntity
import com.example.nbc_standard_4_week.databinding.ItemCard3Binding
import com.example.nbc_standard_4_week.presentation.model.DataModel
import java.text.DecimalFormat

class Card3ViewHolder(private val binding: ItemCard3Binding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dataEntity: DataModel){
        binding.apply {
            tvName.text = dataEntity.tvName
            tvCardNum1.text = dataEntity.num1.chunked(4).joinToString(" ")
            tvYM.text = dataEntity.YM
            val decimal = DecimalFormat("#,##,###.00")
            tvPrice.text = decimal.format(dataEntity.price)
        }
    }
}