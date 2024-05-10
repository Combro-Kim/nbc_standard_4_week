package com.example.nbc_standard_4_week.presentation.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nbc_standard_4_week.R
import com.example.nbc_standard_4_week.presentation.myStorage.main.MyStorageFragment
import com.example.nbc_standard_4_week.presentation.search.main.SearchFragment

class ViewPagerAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val fragments = listOf(
        FragmentTabModel(fragment = SearchFragment.newInstance(), title = R.string.search_fragment_name),
        FragmentTabModel(fragment = MyStorageFragment.newInstance(), title = R.string.myStorage_fragment_name),
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position].fragment

    fun getTitle(position: Int): Int = fragments[position].title
}