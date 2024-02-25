package com.example.socialproblemandroid.data.repository

import android.util.Log
import com.example.socialproblemandroid.data.datasource.NewsDataSource
import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import com.example.socialproblemandroid.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsDataSource: NewsDataSource) :
    NewsRepository {
    override suspend fun getNewsInfo(): Result<NewsResponse> =
        runCatching {
            newsDataSource.getNewsInfo()
        }.onSuccess {
            Log.e("hyeoon", "news 데이터 통신 성공")
            Log.e("hyeon",it.toString())
        }.onFailure {
            Log.e("hyeoon",it.message.toString())
            Log.e("hyeoon", "news 데이터 통신 실패")
        }
}