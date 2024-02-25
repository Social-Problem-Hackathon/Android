package com.example.socialproblemandroid.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.socialproblemandroid.R
import com.example.socialproblemandroid.databinding.FragmentHomeBinding
import com.example.socialproblemandroid.presentation.home.news.NewsAdapter
import com.example.socialproblemandroid.presentation.news.NewsActivity
import com.example.socialproblemandroid.util.base.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home){
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observeNewsData()
    }

    private fun observeNewsData(){
        viewModel.newsResponse.observe(viewLifecycleOwner) {
            newsAdapter.submitList(it)
        }
    }

    private fun initAdapter() {
        newsAdapter = NewsAdapter {
            Intent(Intent(requireContext(), NewsActivity::class.java)).apply {
                startActivity(this)
            }
        }
        binding.rvTodayNews.adapter = newsAdapter
    }
}
