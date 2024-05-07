package com.example.nbc_standard_4_week.network

import com.example.nbc_standard_4_week.data.remote.SearchRemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//retrofit 사용하기 위한 세팅
object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //retrofit 객체와 interface(SearchRemoteDataSource) 연결
    val searchGitHubUser: SearchRemoteDataSource by lazy { retrofit.create(SearchRemoteDataSource::class.java) }
}