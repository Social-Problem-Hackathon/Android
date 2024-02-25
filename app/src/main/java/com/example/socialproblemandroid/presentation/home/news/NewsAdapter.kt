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
        private fun categorizeTag(ministerCode: String): String {
            return when {
                KEYWORDS_ECONOMY.any { it in ministerCode } -> "#경제 #돈 #관세 #수입 #수출"
                KEYWORDS_LABOR.any { it in ministerCode } -> "#노동 #고용"
                KEYWORDS_SOCIETY.any { it in ministerCode } -> "#사회 #외교"
                KEYWORDS_WELFARE.any { it in ministerCode } -> "#의료 #복지"
                else -> ""
            }
        }

        fun onBind(data: NewsItem) {
            with(binding) {
                tvNewsTopic.text = data.title
                ivNewsTumbnail.load(data.originalImgUrl) {
                    crossfade(true)
                }
                tvNewsTag.text = categorizeTag(data.ministerCode!!)
                ivTopicTumbnail.load(
                    when (categorizeTag(data.ministerCode)) {
                        "#경제 #돈 #관세 #수입 #수출" -> R.drawable.img_money
                        "#노동 #고용" -> R.drawable.img_labor
                        "#사회 #외교" -> R.drawable.img_society
                        "#의료 #복지" -> R.drawable.img_welfare
                        else -> R.drawable.img_white
                    }
                ) {
                    transformations(CircleCropTransformation())
                }
                root.setOnSingleClickListener {
                    itemClick(data)
                }
            }
        }
    }

    companion object {
        val KEYWORDS_ECONOMY = listOf("기획재정부", "농림축산식품부", "산업통상자원부" ,"해양수산부", "중소벤처기업부")
        val KEYWORDS_LABOR = listOf("고용노동부")
        val KEYWORDS_WELFARE = listOf("보건복지부", "여성가족부", "방송통신위원회", "행정안전부", "소방청")
        val KEYWORDS_SOCIETY = listOf("환경부", "행정자치부", "외교부", "문화체육관광부", "교육부", "통일부")

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