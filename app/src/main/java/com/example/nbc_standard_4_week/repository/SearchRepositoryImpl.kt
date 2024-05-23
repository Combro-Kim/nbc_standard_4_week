package com.example.nbc_standard_4_week.repository


import com.example.nbc_standard_4_week.repository.SearchRepository
import com.example.nbc_standard_4_week.data.remote.SearchRemoteDataSource
import com.example.nbc_standard_4_week.presentation.search.mapper.toEntity
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity

class SearchRepositoryImpl(private val remoteDataSource: SearchRemoteDataSource): SearchRepository {

    override suspend fun getGitHubUserList(userName: String): GitHubUserListEntity =
//        remoteDataSource.getGitHubUser(userName) //mapper 필요!
        remoteDataSource.getGitHubUser(userName).toEntity()
}