package com.example.nbc_standard_4_week.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val selectedData = intent.getParcelableExtra("selectedData", Data::class.java)
        selectedData?.let { eachData(it) }
        Log.d("DetailActivity", "Received data: $selectedData")

    }

    @SuppressLint("SetTextI18n")
    private fun eachData(data: Data) {
        binding.tvName.text = "이름 : ${data.tvName}"
        binding.tvNum.text = "카드번호 : ${data.num1} ${data.num2}  ${data.num3}  ${data.num4}"
        binding.tvYM.text = "유효기간 : ${data.YM}"
        val decimal = DecimalFormat("#,##,###.00")
        binding.tvPrice.text = "가격 : ${decimal.format(data.price)}"
    }
}