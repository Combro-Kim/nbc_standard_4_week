package com.example.nbc_standard_4_week.data.remote.retrofit

import com.example.nbc_standard_4_week.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    this.addHeader("Authorization", BuildConfig.API_KEY)
                }
                .build()
        )
    }
}