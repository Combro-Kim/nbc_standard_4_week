package com.example.nbc_standard_4_week.repository

import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity

interface SearchRepository {
    suspend fun getGitHubUserList(userName: String) : GitHubUserListEntity
}