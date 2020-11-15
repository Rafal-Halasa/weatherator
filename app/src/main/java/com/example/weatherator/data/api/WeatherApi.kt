package com.example.weatherator.data.api

import com.example.weatherator.data.models.weather_new.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("forecasts/v1/daily/1day/{location_id}?apikey=mGxxGcypHUCeYpC290UxnhxTFu1oqA3X&language=pl")
    suspend fun get(
        @Path(value = "location_id", encoded = true) locationId: String
    ): WeatherModel

}