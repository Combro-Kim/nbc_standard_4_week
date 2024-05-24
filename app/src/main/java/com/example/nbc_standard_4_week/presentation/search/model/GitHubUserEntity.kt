package com.example.nbc_standard_4_week.presentation.search.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUserList(
    val items: List<GitHubUser>
):Parcelable

@Parcelize
data class GitHubUser(
    val login: String,
    val id: Int,
    val htmlUrl: String,
    val avatarUrl: String,
    var isLiked: Boolean = false
):Parcelable