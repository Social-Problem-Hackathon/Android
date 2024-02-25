package com.example.socialproblemandroid.data.service

import com.example.socialproblemandroid.BuildConfig
import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("policyNewsList")
    suspend fun getNewsInfo(
        @Query("serviceKey") apiKey: String = BuildConfig.API_KEY,
        @Query("startDate") startDate: String ="20240223",
        @Query("endDate") endDate: String ="20240223"
    ): NewsResponse
}