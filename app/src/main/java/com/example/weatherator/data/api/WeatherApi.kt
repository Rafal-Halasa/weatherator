package com.example.weatherator.data.api

import com.example.weatherator.data.models.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather?appid=188cdd0b16a360a4f54f5e8bc9367edc&units=metric")
    suspend fun get(
        @Query(value = "lat", encoded = true) lat: Double,
        @Query(value = "lon", encoded = true) lon: Double
    ): WeatherModel

    @GET("weather?appid=188cdd0b16a360a4f54f5e8bc9367edc&units=metric")
    suspend fun get(
        @Query(value = "q", encoded = true) cityName: String
    ): WeatherModel
}