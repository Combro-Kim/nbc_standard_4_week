package com.example.nbc_standard_4_week.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

//todo myStorage와 비교해서 switch on
class SharedViewModel : ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUserEntity>>()
    val favoriteLiveData: LiveData<List<GitHubUserEntity>> = _favoriteLiveData

    private val favoriteUsers = mutableListOf<GitHubUserEntity>()

    fun setFavoriteList(user: GitHubUserEntity) {
        val index = favoriteUsers.indexOfFirst { it.id == user.id }
        if (index >= 0) {
            favoriteUsers.removeAt(index)
        } else {
            favoriteUsers.add(user.copy(isLiked = true))
        }
        _favoriteLiveData.value = favoriteUsers.toList()
    }

    fun isFavorite(userId: Int): Boolean {
        return favoriteUsers.any { it.id == userId }
    }
}