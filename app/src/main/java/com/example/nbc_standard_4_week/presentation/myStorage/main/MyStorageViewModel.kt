package com.example.nbc_standard_4_week.presentation.myStorage.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity

class MyStorageViewModel: ViewModel() {
    private val _favoriteUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val favoriteUserList: LiveData<List<GitHubUserEntity>> get() = _favoriteUserList

}