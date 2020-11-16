package com.example.weatherator.data.models.weather_new

import java.text.SimpleDateFormat

data class DailyForecast(
    val Date: String,
    val Day: Day,
    val EpochDate: Long,
    val Link: String,
    val MobileLink: String,
    val Night: Night,
    val Sources: List<String>,
    val Temperature: Temperature
) {
    fun getDay(): String {
        val simpleDateFormat = SimpleDateFormat("EEEE")
        return simpleDateFormat.format(java.util.Date(EpochDate * 1000))
    }
}