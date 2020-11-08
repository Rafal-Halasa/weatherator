package com.example.weatherator.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    private val retrofit
        get() = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiWeather = retrofit.create(WeatherApi::class.java)
}