package com.example.nbc_standard_4_week.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_standard_4_week.presentation.myStorage.main.MyStorageFragment
import com.example.nbc_standard_4_week.R
import com.example.nbc_standard_4_week.databinding.ActivityMainBinding
import com.example.nbc_standard_4_week.presentation.search.main.SearchFragment


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initFirstFragment()
        setUpBottomNavigation()
    }

    private fun initFirstFragment(){
        //메인화면은 SearchFragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, SearchFragment())
            commit()
        }
    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_search -> {
                    val searchFragment = SearchFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, searchFragment)
                        .commit()
                    true
                }

                R.id.page_myStorage -> {
                    val myStorageFragment = MyStorageFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, myStorageFragment)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }


}