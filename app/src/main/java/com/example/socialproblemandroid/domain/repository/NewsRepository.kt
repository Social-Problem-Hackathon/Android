package com.example.socialproblemandroid.domain.repository

import com.example.socialproblemandroid.data.model.remote.response.NewsResponse

interface NewsRepository {
    suspend fun getNewsInfo() : Result<NewsResponse>
}