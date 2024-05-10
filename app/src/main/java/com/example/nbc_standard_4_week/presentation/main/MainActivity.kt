package com.example.nbc_standard_4_week.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_standard_4_week.presentation.myStorage.main.MyStorageFragment
import com.example.nbc_standard_4_week.R
import com.example.nbc_standard_4_week.databinding.ActivityMainBinding
import com.example.nbc_standard_4_week.presentation.search.main.SearchFragment
import com.example.nbc_standard_4_week.presentation.search.main.SearchViewModel
import com.example.nbc_standard_4_week.presentation.search.main.SearchViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewPagerAdapter by lazy {
        ViewPagerAdapter(this)
    }
    private val searchViewModel by viewModels<SearchViewModel> {
        SearchViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()

    }

    private fun initView() = with(binding) {
        viewPager.adapter = viewPagerAdapter
        //viewPager에 화면 수 세팅
        viewPager.offscreenPageLimit = viewPagerAdapter.itemCount

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()
    }

}