package com.home.newsapi.ui.news.model

data class NewsUi(
    val description: String?,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String?
)
