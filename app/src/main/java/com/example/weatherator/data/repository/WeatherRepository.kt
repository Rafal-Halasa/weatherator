package com.example.weatherator.data.repository

import com.example.weatherator.data.api.RetrofitObject
import com.example.weatherator.data.models.weather_new.WeatherModel

class WeatherRepository : Repository {
    override suspend fun getByCityName(cityName: String) = RetrofitObject.apiWeather.get(cityName)

}

interface Repository {
    suspend fun getByCityName(cityName: String): WeatherModel
}