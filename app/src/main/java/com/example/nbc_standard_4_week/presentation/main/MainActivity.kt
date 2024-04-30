package com.example.nbc_standard_4_week.presentation.main

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.nbc_standard_4_week.databinding.ActivityMainBinding
import com.example.nbc_standard_4_week.presentation.detail.DetailActivity
import com.example.nbc_standard_4_week.presentation.adapter.DataAdapter
import com.example.nbc_standard_4_week.presentation.model.DataModel

// todo 주석달기
// todo RecyclerView LiveData로 변경
// todo DetailActivity 데이터 ViewModel에서 받기

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    //ViewModel에서 받아오기 때문에 여기서 사용 안함
    //    private var dataSource = DataSource.getDataSource()

    private val dataAdapter: DataAdapter by lazy {
        DataAdapter { card ->
            adapterOnClick(card)
        }
    }
    private lateinit var dataList: List<DataModel>

    //price
    private val tvDollar: TextView by lazy {
        binding.tvDollar
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showTotalPrice()
        recyclerViewDivider()

        initViewModel()
        initData()
    }

    //item 간격 추가
    private fun recyclerViewDivider() {
        binding.recyclerView.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = 40
            }
        })
    }

    //Live Data실습 (총금액 변경해보기)
    private fun showTotalPrice() {
        mainViewModel.totalPrice.observe(this) {
            tvDollar.text = it
        }
        mainViewModel.updateTotalPrice()
    }

    private fun initData(){
        mainViewModel.getDataModel()
    }
    private fun initView(){
        dataAdapter.dataList = dataList
        with(binding.recyclerView){
            adapter = dataAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel(){
        mainViewModel.getDataModel.observe(this@MainActivity){
            dataList = it

            initView()
        }
    }

    private fun adapterOnClick(card : DataModel){
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.SELECTED_DATA,card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}