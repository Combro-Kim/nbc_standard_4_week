package com.example.nbc_standard_4_week.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUser
import com.example.nbc_standard_4_week.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) : ViewModel() {
    private val _getGitHubUserList: MutableLiveData<List<GitHubUser>> = MutableLiveData()
    val getGithubUserList: LiveData<List<GitHubUser>> get() = _getGitHubUserList

    fun searchGitHubUserList(userName: String) {
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList(userName).items
        }
    }
}

//class SearchViewModelFactory : ViewModelProvider.Factory {
//    private val repository = SearchRepositoryImpl(RetrofitClient.searchGitHubUser)
//    override fun <T : ViewModel> create(
//        modelClass: Class<T>,
//        extras: CreationExtras
//    ): T {
//        return SearchViewModel(repository) as T
//    }
//}