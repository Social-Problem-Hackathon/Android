package com.example.socialproblemandroid.presentation.news

import android.os.Bundle
import com.example.socialproblemandroid.R
import com.example.socialproblemandroid.databinding.ActivityNewsBinding
import com.example.socialproblemandroid.util.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : BindingActivity<ActivityNewsBinding>(R.layout.activity_news) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}