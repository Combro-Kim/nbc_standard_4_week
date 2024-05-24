package com.example.nbc_standard_4_week.data.remote.di

import com.example.nbc_standard_4_week.data.repository.SearchRepositoryImpl
import com.example.nbc_standard_4_week.data.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SearchModule {
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}