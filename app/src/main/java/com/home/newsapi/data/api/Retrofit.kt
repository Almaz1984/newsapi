package com.home.newsapi.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofit {

    private const val BASE_URL = "https://newsapi.org/v2/"
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getApi(): ApiService = retrofit.create(ApiService::class.java)
}
