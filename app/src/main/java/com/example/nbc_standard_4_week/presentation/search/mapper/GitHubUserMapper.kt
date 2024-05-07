package com.example.nbc_standard_4_week.presentation.search.mapper

import com.example.nbc_standard_4_week.data.remote.GitHubUserListResponse
import com.example.nbc_standard_4_week.data.remote.GitHubUserResponse
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserEntity
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserListEntity

fun GitHubUserListResponse.toEntity() = GitHubUserListEntity(
    items = items.asGitHubUserEntity()
)
fun List<GitHubUserResponse>.asGitHubUserEntity() : List<GitHubUserEntity>{
    return map{
        GitHubUserEntity(
            it.login,
            it.id,
            it.htmlUrl,
            it.avatarUrl
        )
    }
}
