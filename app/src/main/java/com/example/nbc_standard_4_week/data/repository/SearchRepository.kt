package com.example.nbc_standard_4_week.data.repository

import com.example.nbc_standard_4_week.data.remote.remote.SearchRemoteDataSource
import com.example.nbc_standard_4_week.presentation.search.mapper.toEntity
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserList
import javax.inject.Inject

interface SearchRepository {
    suspend fun getGitHubUserList(userName: String) : GitHubUserList
}

class SearchRepositoryImpl @Inject constructor(private val remoteDataSource: SearchRemoteDataSource) :
    SearchRepository {
    override suspend fun getGitHubUserList(userName: String): GitHubUserList =
        remoteDataSource.getGitHubUser(userName).toEntity()
}