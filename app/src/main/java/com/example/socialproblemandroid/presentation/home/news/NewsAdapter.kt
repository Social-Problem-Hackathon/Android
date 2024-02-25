package com.example.socialproblemandroid.presentation.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.socialproblemandroid.data.model.remote.response.NewsItem
import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import com.example.socialproblemandroid.databinding.ItemTodayNewsBinding
import com.example.socialproblemandroid.util.setOnSingleClickListener


class NewsAdapter(private val itemClick: (NewsItem) -> (Unit)) : ListAdapter<NewsItem, NewsAdapter.NewsViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder{
        val binding =
            ItemTodayNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class NewsViewHolder(
        private val binding: ItemTodayNewsBinding,
        private val itemClick: (NewsItem) -> (Unit)
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NewsItem) {
            with(binding) {
                tvNewsTopic.text = data.title
                ivNewsTumbnail.load(data.originalImgUrl){
                    crossfade(true)
                }
                tvNewsTag.text = "" //content에 contains로 tag 판단 (type 사용하기!)
                root.setOnSingleClickListener {
                    itemClick(data)
                }
            }
        }
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<NewsItem>() {
            override fun areItemsTheSame(
                oldItem: NewsItem,
                newItem: NewsItem
            ): Boolean {
                return oldItem.newsItemId == newItem.newsItemId
            }

            override fun areContentsTheSame(
                oldItem: NewsItem,
                newItem: NewsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}