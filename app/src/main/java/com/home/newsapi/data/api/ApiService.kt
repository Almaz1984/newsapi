package com.home.newsapi.data.api

import com.home.newsapi.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun loadNews(
        @Query("country") countryCode: String = COUNTRY_CODE,
        @Query("page") pageNumber: String = PAGE_SIZE,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

    companion object {
        const val API_KEY = "3794f2e1f135498b83ca151a3b5ce44c"
        const val PAGE_SIZE = "1"
        const val COUNTRY_CODE = "ru"
    }
}
