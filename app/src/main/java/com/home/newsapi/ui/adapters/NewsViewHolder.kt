package com.home.newsapi.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.newsapi.R
import com.home.newsapi.ui.news.model.NewsUi
import com.home.newsapi.databinding.ItemNewsBinding

class NewsViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: NewsUi) {
        apply {
            binding.apply {

                Glide.with(newsImage)
                    .load(news.urlToImage)
                    .placeholder(R.drawable.ic_update)
                    .error(R.drawable.ic_broken)
                    .into(newsImage)

                newsTitle.text = news.title
                newsDescription.text = news.description
                newsDate.text = news.publishedAt
            }
        }
    }
}
