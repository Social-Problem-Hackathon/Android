package com.example.socialproblemandroid.di

import com.example.socialproblemandroid.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("jsonRetrofit")
    fun provideITdaRetrofit(client: OkHttpClient, @Named("jsonConverter")jsonConverter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl("") // 잇다 BASE_URL
            .client(client)
            .addConverterFactory(jsonConverter)
            .build()
    // JSON 데이터를 통신하기 위한 Retrofit 인스턴스를 제공하는 메서드

    @Provides
    @Singleton
    @Named("jsonConverter")
    fun provideJsonConverterFactory(): Converter.Factory {
        return Json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    @Named("xmlConverter")
    fun provideXmlConverterFactory(): Converter.Factory {
        return TikXmlConverterFactory.create()
    }

    @Provides
    @Singleton
    @Named("xmlRetrofit")
    fun provideNewsRetrofit(client: OkHttpClient, @Named("xmlConverter")xmlConverter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_BASE_URL) // XML 데이터 BASE_URL
            .client(client)
            .addConverterFactory(xmlConverter)
            .build()
    // XML 데이터를 통신하기 위한 Retrofit 인스턴스를 제공 메서드

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .build()

}
