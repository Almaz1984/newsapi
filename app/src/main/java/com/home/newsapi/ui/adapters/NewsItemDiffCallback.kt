package com.home.newsapi.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.home.newsapi.ui.news.model.NewsUi

class NewsItemDiffCallback : DiffUtil.ItemCallback<NewsUi>() {

    override fun areItemsTheSame(oldItem: NewsUi, newItem: NewsUi) = oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: NewsUi, newItem: NewsUi) = oldItem == newItem
}
