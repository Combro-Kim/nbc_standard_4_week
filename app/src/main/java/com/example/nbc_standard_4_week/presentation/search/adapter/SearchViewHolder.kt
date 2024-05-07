package com.example.nbc_standard_4_week.presentation.search.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc_standard_4_week.databinding.ItemUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity

class SearchViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(searchItem : GitHubUserEntity){
        binding.apply {
            tvLogin.text = searchItem.login
            tvURL.text = searchItem.htmlUrl
            Glide.with(itemView.context)
                .load(searchItem.avatarUrl)
                .into(ivAvatarURL)
        }
    }
}