package com.example.socialproblemandroid.presentation.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.socialproblemandroid.R
import com.example.socialproblemandroid.data.model.remote.response.NewsItem
import com.example.socialproblemandroid.data.model.remote.response.NewsResponse
import com.example.socialproblemandroid.databinding.ItemTodayNewsBinding
import com.example.socialproblemandroid.presentation.type.NewsCategoryType
import com.example.socialproblemandroid.util.setOnSingleClickListener


class NewsAdapter(private val itemClick: (NewsItem) -> (Unit)) :
    ListAdapter<NewsItem, NewsAdapter.NewsViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
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
        private fun categorizeTag(ministerCode: String): NewsCategoryType {
            return NewsCategoryType.values()
                .firstOrNull { it.keywords.any { keyword -> keyword in ministerCode } }
                ?: NewsCategoryType.UNKNOWN
        }

        fun onBind(data: NewsItem) {
            with(binding) {
                val category = categorizeTag(data.ministerCode!!)
                tvNewsTopic.text = data.title
                ivNewsTumbnail.load(data.originalImgUrl) {
                    crossfade(true)
                }
                tvNewsTag.text = category.tag
                ivTopicTumbnail.load(category.iconRes) {
                    transformations(CircleCropTransformation())
                }
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