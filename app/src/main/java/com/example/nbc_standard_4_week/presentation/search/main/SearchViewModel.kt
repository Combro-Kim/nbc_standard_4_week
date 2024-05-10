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

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGithubUserList: LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList


    private val _favoriteUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val favoriteUserList: LiveData<List<GitHubUserEntity>> get() = _favoriteUserList

    fun searchGitHubUserList(userName: String) {
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList(userName).items
        }
    }

    fun setFavoriteItem(item: GitHubUserEntity) {
        //toMutableList 수정가능 한 List로 변경
        val gitHubUserList = _getGitHubUserList.value?.toMutableList() ?: mutableListOf()

        //매칭된 아이템의 index를 반환
        val position = gitHubUserList.indexOfFirst {
            it.id == item.id
        }
        Log.d("fffffff", "$position")
        _getGitHubUserList.value =
                //livedata에서 받아온 list를 index으로 sorting해서 data class copy함 (data class의 객체를 복사)
            gitHubUserList.also {
                it[position] = item.copy(
                    //bool 값을 반대값 세팅
                    isLiked = !item.isLiked
                )
            }

        _favoriteUserList.value = gitHubUserList.filter { it.isLiked }
    }
}

class SearchViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(RetrofitClient.searchGitHubUser)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SearchViewModel(repository) as T
    }
}