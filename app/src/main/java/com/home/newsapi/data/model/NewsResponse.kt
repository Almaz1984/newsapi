package com.home.newsapi.data.model

data class NewsResponse(
    val articles: List<NewsItemDto>,
    val status: String,
    val totalResults: Int?
)
