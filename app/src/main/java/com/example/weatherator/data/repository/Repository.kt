package com.example.weatherator.data.repository

import com.example.weatherator.data.api.RetrofitObject
import com.example.weatherator.data.models.WeatherModel

class WeatherRepository : Repository {
    override suspend fun getByName(cityName: String) = RetrofitObject.apiWeather.get(cityName)

    override suspend fun getByLatLong(lat: Double, long: Double) =
        RetrofitObject.apiWeather.get(lat, long)

}

interface Repository {
    suspend fun getByName(cityName: String): WeatherModel
    suspend fun getByLatLong(lat: Double, long: Double): WeatherModel
}