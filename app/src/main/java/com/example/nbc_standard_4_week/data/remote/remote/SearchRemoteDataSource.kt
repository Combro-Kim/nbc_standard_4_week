package com.example.nbc_standard_4_week.data.remote.remote

import com.example.nbc_standard_4_week.BuildConfig
import com.example.nbc_standard_4_week.data.model.GitHubUserListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface SearchRemoteDataSource {
//    @Headers("Authorization: ${BuildConfig.API_KEY}")
    @GET("search/users")
    suspend fun getGitHubUser(
        @Query("q") name: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 100,
        ) : GitHubUserListResponse
}