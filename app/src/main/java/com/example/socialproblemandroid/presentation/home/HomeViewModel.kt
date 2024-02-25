package com.example.socialproblemandroid.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialproblemandroid.data.model.remote.response.NewsItem
import com.example.socialproblemandroid.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    init{
        getNewsInfo()
    }

    private var _newsResponse = MutableLiveData<List<NewsItem>>()
    val newsResponse: LiveData<List<NewsItem>> = _newsResponse

    fun getNewsInfo() {
        viewModelScope.launch {
            newsRepository.getNewsInfo()
                .onSuccess { newsResponse ->
                    _newsResponse.value = newsResponse.body.newsItems
                    Log.e("hyeon", "news get 성공 ")
                    Log.e("hyeon",_newsResponse.value.toString())
                }.onFailure {
                    Log.e("hyeon", "news get 실패 ")
                }
        }
    }
}