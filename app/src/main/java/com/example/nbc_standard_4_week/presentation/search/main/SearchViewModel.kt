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
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.example.nbc_standard_4_week.presentation.search.repository.SearchRepository
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository):ViewModel() {

//    private val _getGitHubUserList : MutableLiveData<List<GitHubUserListEntity>> = MutableLiveData()
    private val _getGitHubUserList : MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
//    val getGithubUserList : LiveData<List<GitHubUserListEntity>> get() = _getGitHubUserList
    val getGithubUserList : LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList

    fun getGitHubUserList(userName : String){ //검색어 넣으면 됨
        viewModelScope.launch {
            val userList = searchRepository.getGitHubUserList(userName)
//            _getGitHubUserList.value = listOf(userList)
            _getGitHubUserList.value = searchRepository.getGitHubUserList(userName).items
//            val newDataset = userList.GitHubUserListEntity ?: emptyList()
//            _imageItems.value = newDataset

            Log.d("SearchViewModel", "API response: ${_getGitHubUserList.value}")
        }
    }
}

//class SearchViewModelFactory : ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>,extras: CreationExtras): T{
//        return SearchViewModel(SearchRepositoryImpl(RetrofitClient.searchGitHubUser)) as T
//    }
//}

class SearchViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(RetrofitClient.searchGitHubUser)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return SearchViewModel(
            repository
        ) as T
    }
}