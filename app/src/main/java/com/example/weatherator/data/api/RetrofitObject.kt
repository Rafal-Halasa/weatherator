package com.example.weatherator.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "http://dataservice.accuweather.com/"
    const val BASE_ICON_URL = "http://openweathermap.org/img/wn/"
    private val retrofit
        get() = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiWeather = retrofit.create(WeatherApi::class.java)
    val apiLocation = retrofit.create(LocationApi::class.java)
}