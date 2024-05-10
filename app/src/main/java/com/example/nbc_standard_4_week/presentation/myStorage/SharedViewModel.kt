package com.example.nbc_standard_4_week.presentation.myStorage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.nbc_standard_4_week.data.repository.SearchRepositoryImpl
import com.example.nbc_standard_4_week.network.RetrofitClient
import com.example.nbc_standard_4_week.presentation.search.main.SearchViewModel
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.example.nbc_standard_4_week.presentation.search.repository.SearchRepository
import javax.sql.DataSource

class SharedViewModel: ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUserEntity>>()
    val favoriteLiveData: LiveData<List<GitHubUserEntity>> = _favoriteLiveData

    fun setFavoriteList(list: List<GitHubUserEntity>) {
        _favoriteLiveData.value = list
    }
}
