package com.example.socialproblemandroid.data.datasourceimpl

import com.example.socialproblemandroid.data.datasource.NewsDataSource
import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import com.example.socialproblemandroid.data.service.NewsService
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val newsService: NewsService
) : NewsDataSource {
    override suspend fun getNewsInfo() = newsService.getNewsInfo()
}