package com.example.socialproblemandroid.di

import com.example.socialproblemandroid.data.datasource.NewsDataSource
import com.example.socialproblemandroid.data.datasourceimpl.NewsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsNewsDataSource(newsDataSourceImpl: NewsDataSourceImpl): NewsDataSource
}