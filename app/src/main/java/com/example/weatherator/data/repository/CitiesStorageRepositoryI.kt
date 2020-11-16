package com.example.weatherator.data.repository

import android.content.SharedPreferences
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.cities.CitiesModelItem
import com.example.weatherator.data.storage.userCitiesList

class CitiesStorageRepository(val preferences: SharedPreferences) : CitiesStorageRepositoryI {
    override fun putCity(city: CitiesModelItem) {
        val citiesList = preferences.userCitiesList
        citiesList.add(city)
        val take = citiesList.takeLast(3)
        println("tutaj list $take ")
        val newCitiesModel = CitiesModel()
        newCitiesModel.addAll(take)
        newCitiesModel.reverse()
        preferences.userCitiesList = newCitiesModel
    }
}

interface CitiesStorageRepositoryI {
    fun putCity(city: CitiesModelItem)
}
