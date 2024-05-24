package com.example.nbc_standard_4_week.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUser

//todo myStorage와 비교해서 switch on
class SharedViewModel : ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUser>>()
    val favoriteLiveData: LiveData<List<GitHubUser>> = _favoriteLiveData

    private val favoriteUsers = mutableListOf<GitHubUser>()

    fun setFavoriteList(user: GitHubUser) {
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