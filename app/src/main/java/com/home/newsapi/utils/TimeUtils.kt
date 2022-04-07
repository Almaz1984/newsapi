package com.home.newsapi.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object TimeUtils {
    private const val DATE_PARSER_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    fun getFormattedDate(date: String?): String {
        val dateFormat = DateTimeFormatter.ofPattern(DATE_PARSER_PATTERN)
        val parsedDate = LocalDate.parse(date, dateFormat)

        return "${parsedDate.getMonthName()} ${parsedDate.dayOfMonth}, ${parsedDate.year}"
    }

    private fun LocalDate.getMonthName(): String {
        val months = listOf(
            "Январь",
            "Февраль",
            "Март",
            "Апрель",
            "Май",
            "Июнь",
            "Июль",
            "Август",
            "Сентябрь",
            "Октябрь",
            "Ноябрь",
            "Декабрь"
        )
        return months[monthValue - 1]
    }
}
