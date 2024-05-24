package com.example.nbc_standard_4_week.presentation.search.mapper

import com.example.nbc_standard_4_week.data.model.GitHubUserListResponse
import com.example.nbc_standard_4_week.data.model.GitHubUserResponse
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUser
import com.example.nbc_standard_4_week.presentation.search.model.GitHubUserList

fun GitHubUserListResponse.toEntity() = GitHubUserList(
    items = items.asGitHubUser()
)
fun List<GitHubUserResponse>.asGitHubUser() : List<GitHubUser>{
    return map{
        GitHubUser(
            it.login,
            it.id,
            it.htmlUrl,
            it.avatarUrl
        )
    }
}
