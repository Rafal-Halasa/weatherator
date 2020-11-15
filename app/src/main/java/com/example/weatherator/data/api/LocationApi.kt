package com.example.weatherator.data.api

import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.weather_new.WeatherModel
import com.example.weatherator.ui.base.Keys.Companion.APi_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApi {
    @GET("locations/v1/cities/autocomplete?apikey=${APi_KEY}&language=pl")
    suspend fun get(@Query("q") q: String): CitiesModel
}