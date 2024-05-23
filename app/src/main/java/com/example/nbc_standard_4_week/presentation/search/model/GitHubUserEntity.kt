package com.example.nbc_standard_4_week.presentation.search.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUserListEntity(
    val items: List<GitHubUserEntity>
):Parcelable

@Parcelize
data class GitHubUserEntity(
    val login: String,
    val id: Int,
    val htmlUrl: String,
    val avatarUrl: String,
    var isLiked: Boolean = false
):Parcelable