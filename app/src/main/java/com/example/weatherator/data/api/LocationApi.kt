package com.example.weatherator.data.api

import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.weather_new.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApi {
    @GET("locations/v1/cities/autocomplete?apikey=yPixSuA4gIeEQIaEqUjE4JDwlKzFtvJ7&language=pl")
    suspend fun get(@Query("q") q: String): CitiesModel
}