package com.example.nbc_standard_4_week.presentation.search.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

class SearchViewHolder(private val binding: ItemLinearUserBinding,private val onClick: (GitHubUserEntity) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bind(searchItem : GitHubUserEntity){
        binding.apply {
            tvLogin.text = searchItem.login
            Glide.with(itemView.context)
                .load(searchItem.avatarUrl)
                .into(ivAvatarURL)
//            swLike.setOnClickListener {
//                if (searchItem.isLiked != swLike.isChecked) {
//                    onClick(searchItem)
//                }
//            }
            swLike.isChecked = searchItem.isLiked
            swLike.setOnCheckedChangeListener { _, isChecked ->
                if (searchItem.isLiked != isChecked) {
                    onClick(searchItem)
                }
            }
        }
    }
}