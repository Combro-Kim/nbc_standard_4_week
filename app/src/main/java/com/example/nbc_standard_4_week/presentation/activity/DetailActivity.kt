package com.example.nbc_standard_4_week.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.nbc_standard_4_week.databinding.ActivityDetailBinding
import com.example.nbc_standard_4_week.presentation.viewModel.DetailViewModel
import com.example.nbc_standard_4_week.presentation.viewModel.MainViewModel
import com.example.nbc_standard_4_week.presentation.viewModel.MainViewModelFactory
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private val detailViewModel: DetailViewModel by viewModels()
    companion object {
        const val SELECTED_DATA : String = "selectedItemId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() { // todo ViewModel에서 받아오기
        val selectedItemId = intent.getIntExtra(SELECTED_DATA, -1)
        val eachData = detailViewModel.getDataForId(selectedItemId)
        binding.tvName.text = eachData?.tvName
        binding.tvNum.text = "${eachData?.num1}  ${eachData?.num2}  ${eachData?.num3}  ${eachData?.num4}"
        binding.tvYM.text = eachData?.YM
        val decimal = DecimalFormat("#,##,###.00")
        binding.tvPrice.text = decimal.format(eachData?.price)
    }


}