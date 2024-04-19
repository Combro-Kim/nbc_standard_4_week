package com.example.nbc_standard_4_week.presentation

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.nbc_standard_4_week.data.DataSource
import com.example.nbc_standard_4_week.data.dataList
import com.example.nbc_standard_4_week.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var dataSource = DataSource.getDataSource()
    private lateinit var adapter: DataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showTotalPrice()
        recyclerViewDivider()
        initRecyclerView()


    }
    private fun initRecyclerView() {
//        val adapter = DataAdapter(dataSource.getDataList())
        adapter = DataAdapter(dataSource.getDataList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.itemClick = object : DataAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedData = dataSource.getDataList()[position]
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("selectedData", selectedData)
                startActivity(intent)
            }
        }
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
    private fun showTotalPrice() {
        val totalPrice = dataList().sumOf { it.price }
        val decimal = DecimalFormat("#,##,###.00")
        binding.tvDollar.text = decimal.format(totalPrice)
    }
}