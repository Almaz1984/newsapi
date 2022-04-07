package com.home.newsapi.ui.news.mapper

import com.home.newsapi.data.model.NewsItemDto
import com.home.newsapi.ui.news.model.NewsUi
import com.home.newsapi.utils.TimeUtils

object NewsDtoToNewsUiMapper : (NewsItemDto) -> NewsUi() {

    override fun invoke(newsItemDto: NewsItemDto): NewsUi {
        return NewsUi(
            description = newsItemDto.description,
            publishedAt = TimeUtils.getFormattedDate(newsItemDto.publishedAt),
            title = newsItemDto.title,
            url = newsItemDto.url,
            urlToImage = newsItemDto.urlToImage
        )
    }
}
