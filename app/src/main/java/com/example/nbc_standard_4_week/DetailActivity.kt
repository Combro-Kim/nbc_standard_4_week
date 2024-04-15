package com.example.nbc_standard_4_week

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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