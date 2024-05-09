package com.example.nbc_standard_4_week.presentation.search.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.nbc_standard_4_week.databinding.ItemUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity


class SearchAdapter : ListAdapter<GitHubUserEntity, SearchViewHolder>(DiffCallback){

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchItem = getItem(position)
        holder.bind(searchItem)
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<GitHubUserEntity>() {
        override fun areItemsTheSame(oldItem: GitHubUserEntity, newItem: GitHubUserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubUserEntity, newItem: GitHubUserEntity): Boolean {
            return oldItem == newItem
        }
    }
}