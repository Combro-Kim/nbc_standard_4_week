package com.example.nbc_standard_4_week.presentation.myStorage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

class MyStorageAdapter(private val onClick: (GitHubUserEntity) -> Unit) :
    RecyclerView.Adapter<MyStorageAdapter.MyStorageViewHolder>() {
    private var gitHubUserList = listOf<GitHubUserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyStorageViewHolder {
        val binding = ItemLinearUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyStorageViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: MyStorageViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)
    }

    fun submitList(list: List<GitHubUserEntity>) {
        gitHubUserList = list
        notifyDataSetChanged()
    }

    class MyStorageViewHolder(
        private val binding: ItemLinearUserBinding, private val onClick: (GitHubUserEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteItem: GitHubUserEntity) {
            binding.apply {
                swLike.isChecked = favoriteItem.isLiked
                tvLogin.text = favoriteItem.login
                Glide.with(itemView.context)
                    .load(favoriteItem.avatarUrl)
                    .into(ivAvatarURL)
                swLike.setOnClickListener {
//                    if (searchItem.isLiked != swLike.isChecked) {
                    onClick(favoriteItem)
                }
//                }
            }
        }
    }

}