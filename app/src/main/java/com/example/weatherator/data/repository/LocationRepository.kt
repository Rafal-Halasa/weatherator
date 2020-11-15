package com.example.weatherator.data.repository

import com.example.weatherator.data.api.RetrofitObject
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.weather_new.WeatherModel

class LocationRepository : LocationRepositoryI {
    override suspend fun getCities(regex: String) = RetrofitObject.apiLocation.get(regex)

}

interface LocationRepositoryI {
    suspend fun getCities(regex: String): CitiesModel
}