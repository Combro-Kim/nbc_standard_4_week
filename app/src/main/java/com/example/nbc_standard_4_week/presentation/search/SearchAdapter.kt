package com.example.nbc_standard_4_week.presentation.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc_standard_4_week.databinding.ItemLinearUserBinding
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity


class SearchAdapter(
    private val onClick: (GitHubUserEntity) -> Unit,
    private val isFavorite: (Int) -> Boolean
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

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
        holder.bind(searchItem,isFavorite)
//        holder.itemView.setOnClickListener {
//            onClick(searchItem)
//        }
    }
    fun submitList(list: List<GitHubUserEntity>) {
        gitHubUserList = list
        notifyDataSetChanged()
    }
    class SearchViewHolder(private val binding: ItemLinearUserBinding, private val onClick: (GitHubUserEntity) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchItem: GitHubUserEntity,isFavorite: (Int) -> Boolean) {
            binding.apply {
//                swLike.isChecked = isFavorite(searchItem.isLiked)
                swLike.isChecked = isFavorite(searchItem.id)
                tvLogin.text = searchItem.login
                Glide.with(itemView.context)
                    .load(searchItem.avatarUrl)
                    .into(ivAvatarURL)
                swLike.setOnClickListener {
                    if (searchItem.isLiked != swLike.isChecked) {
                        onClick(searchItem)
                    }
                }
            }
        }
    }
}