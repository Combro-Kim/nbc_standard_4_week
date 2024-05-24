package com.example.nbc_standard_4_week.data.model

import com.google.gson.annotations.SerializedName

data class GitHubUserListResponse (
    @SerializedName("items") val items : List<GitHubUserResponse>
)

data class GitHubUserResponse(
    @SerializedName("login") val login : String,
    @SerializedName("id") val id : Int,
    @SerializedName("html_url") val htmlUrl : String,
    @SerializedName("avatar_url") val avatarUrl : String,
)
