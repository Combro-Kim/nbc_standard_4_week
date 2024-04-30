package com.example.nbc_standard_4_week.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_standard_4_week.databinding.ActivityDetailBinding
import com.example.nbc_standard_4_week.extension.getParcelableExtra
import com.example.nbc_standard_4_week.presentation.model.DataModel
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
//    private val detailViewModel: DetailViewModel by viewModels()

    companion object {
        const val SELECTED_DATA: String = "selectedItemId"
    }
    private val dataModel by getParcelableExtra<DataModel>(SELECTED_DATA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }


    private fun initView() { // todo ViewModel에서 받아오기
        val selectedItemId = intent.getIntExtra(SELECTED_DATA, -1)

        val decimal = DecimalFormat("#,##,###.00")
        binding.tvName.text = dataModel?.tvName
        binding.tvNum.text = dataModel?.num1?.chunked(4)?.joinToString(" ") ?: ""
        binding.tvYM.text = dataModel?.YM
        binding.tvPrice.text = decimal.format(dataModel?.price)
    }
}