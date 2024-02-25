package com.example.socialproblemandroid.di

import com.example.socialproblemandroid.data.service.DocumentsService
import com.example.socialproblemandroid.data.service.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    // XML 뉴스데이터 통신 service
    @Provides
    @Singleton
    fun provideNewsService(@Named("xmlRetrofit")retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)


    // 문서 번역 통신 service
    @Provides
    @Singleton
    fun provideDocumentsService(@Named("jsonRetrofit")retrofit:Retrofit) : DocumentsService =
        retrofit.create(DocumentsService::class.java)
}