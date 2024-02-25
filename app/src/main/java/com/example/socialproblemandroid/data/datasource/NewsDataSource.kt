package com.example.socialproblemandroid.data.datasource

import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import com.example.socialproblemandroid.data.service.NewsService
import javax.inject.Inject

interface NewsDataSource {
    suspend fun getNewsInfo() :NewsResponse
}