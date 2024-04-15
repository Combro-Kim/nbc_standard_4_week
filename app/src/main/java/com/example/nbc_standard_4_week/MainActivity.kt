package com.example.nbc_standard_4_week

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.nbc_standard_4_week.adapter.DataAdapter
import com.example.nbc_standard_4_week.data.dataList
import com.example.nbc_standard_4_week.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showTotalPrice()
        recyclerViewDivider()
        initRecyclerView()


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

    private fun initRecyclerView() {
        val adapter = DataAdapter(dataList())
        val dataList = dataList()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.itemClick = object : DataAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedData = dataList[position]
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("selectedData", selectedData)
                startActivity(intent)
            }
        }
    }

    private fun showTotalPrice() {
        val totalPrice = dataList().sumOf { it.price }
        val decimal = DecimalFormat("#,##,###.00")
        binding.tvDollar.text = decimal.format(totalPrice)
    }
}