package com.example.nbc_standard_4_week.presentation.myStorage.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

class MyStorageViewHolder(private val binding: ItemLinearUserBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(searchItem : GitHubUserEntity){
        binding.apply {
            tvLogin.text = searchItem.login
            Glide.with(itemView.context)
                .load(searchItem.avatarUrl)
                .into(ivAvatarURL)
//            swLike.setOnClickListener{
//                if(searchItem.isLiked != swLike.isChecked){
//                    onClick(searchItem)
//                }
//            }

        }
    }
}