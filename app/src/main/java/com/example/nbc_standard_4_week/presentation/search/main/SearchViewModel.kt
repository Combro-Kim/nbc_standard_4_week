package com.example.nbc_standard_4_week.presentation.search.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.nbc_standard_4_week.data.repository.SearchRepositoryImpl
import com.example.nbc_standard_4_week.network.RetrofitClient
import com.example.nbc_standard_4_week.presentation.myStorage.Room.SelectedItemEntity
import com.example.nbc_standard_4_week.presentation.myStorage.Room.SelectedItemRepository
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.example.nbc_standard_4_week.presentation.search.repository.SearchRepository
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
    private val selectedItemRepository: SelectedItemRepository
) : ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGithubUserList: LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList


    fun getGitHubUserList(userName: String) { //검색어 넣으면 됨
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList(userName).items
        }
    }

    fun saveSelectedItem(selectedItem: GitHubUserEntity) {
        viewModelScope.launch {
            // Document에서 SelectedItemEntity로 변환하여 저장
            val entity = SelectedItemEntity(
                id = selectedItem.id,
                login = selectedItem.login,
                htmlUrl = selectedItem.htmlUrl,
                avatarUrl = selectedItem.avatarUrl,
                isLiked = true
            )
            selectedItemRepository.insertSelectedItem(entity)
        }
    }
}


class SearchViewModelFactory(
    private val searchRepository: SearchRepository,
    private val selectedItemRepository: SelectedItemRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(searchRepository, selectedItemRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}