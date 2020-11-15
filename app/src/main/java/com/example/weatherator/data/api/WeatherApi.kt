package com.example.weatherator.data.api

import com.example.weatherator.data.models.current_wether.CurrnetWetherModel
import com.example.weatherator.data.models.weather_new.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("forecasts/v1/daily/1day/{location_id}?apikey=yPixSuA4gIeEQIaEqUjE4JDwlKzFtvJ7&language=pl")
    suspend fun get(
        @Path(value = "location_id", encoded = true) locationId: String
    ): WeatherModel

    @GET("currentconditions/v1/{location_id}?apikey=yPixSuA4gIeEQIaEqUjE4JDwlKzFtvJ7&language=pl")
    suspend fun getCurrent(
        @Path(value = "location_id", encoded = true) locationId: String
    ): CurrnetWetherModel

}