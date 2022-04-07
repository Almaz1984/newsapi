package com.home.newsapi.domain.repository

import com.home.newsapi.data.api.Retrofit

object NewsRepository {
    private val api = Retrofit.getApi()

    suspend fun loadNews() = api.loadNews()
}
