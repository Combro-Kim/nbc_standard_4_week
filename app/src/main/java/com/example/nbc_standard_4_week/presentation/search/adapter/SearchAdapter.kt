package com.example.nbc_standard_4_week.presentation.search.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity


class SearchAdapter(private val onClick: (GitHubUserEntity) -> Unit) : RecyclerView.Adapter<SearchViewHolder>() {

    var gitHubUserList = listOf<GitHubUserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemLinearUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding,onClick)
    }
    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchItem = gitHubUserList[position]
        holder.bind(searchItem)
        holder.itemView.setOnClickListener {
            onClick(searchItem)
        }
        Log.d("id","$searchItem")
    }
}