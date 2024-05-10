package com.example.nbc_standard_4_week.presentation.myStorage.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.adapter.SearchViewHolder
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

//class MyStorageAdapter(private val onClick:(GitHubUserEntity)-> Unit) : RecyclerView.Adapter<SearchViewHolder>() {
class MyStorageAdapter : RecyclerView.Adapter<MyStorageViewHolder>() {
    var gitHubUserList = listOf<GitHubUserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyStorageViewHolder {
        val binding = ItemLinearUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyStorageViewHolder(binding)
//        return SearchViewHolder(binding,onClick)
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
//        Log.d("아이템 개수","${gitHubUserList.size}")
    }

    override fun onBindViewHolder(holder: MyStorageViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)
//        holder.itemView.setOnClickListener {
//            onClick(currentItem)
//        }
    }
}