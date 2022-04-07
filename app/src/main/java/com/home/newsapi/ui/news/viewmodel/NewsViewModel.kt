package com.home.newsapi.ui.news.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.newsapi.data.model.NewsResponse
import com.home.newsapi.domain.repository.NewsRepository
import com.home.newsapi.ui.news.mapper.NewsDtoToNewsUiMapper
import com.home.newsapi.ui.news.model.NewsUi
import com.home.newsapi.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private val newsRepository = NewsRepository
    val topNews: MutableLiveData<Resource<List<NewsUi>>> = MutableLiveData()

    init {
        getTopNews()
    }

    private fun getTopNews() = viewModelScope.launch {
        topNews.postValue(Resource.Loading())
        try {
            val response = newsRepository.loadNews()
            topNews.postValue(handleNewsResponse(response))
        } catch (e: Exception) {
            topNews.postValue(Resource.Error(e.message ?: UNKNOWN_ERROR))
        }
    }

    private fun handleNewsResponse(response: Response<NewsResponse>): Resource<List<NewsUi>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse.articles.map(NewsDtoToNewsUiMapper))
            }
        }
        return Resource.Error(message = response.message())
    }

    companion object {
        private const val UNKNOWN_ERROR = "Unknown error"
    }
}
