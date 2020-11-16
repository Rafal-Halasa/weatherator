package com.example.weatherator.data.storage

import android.content.SharedPreferences
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.cities.CitiesModelItem
import com.marcinmoskala.kotlinpreferences.bindToPreferenceField
import com.marcinmoskala.kotlinpreferences.bindToPreferenceFieldNullable

var SharedPreferences.userCitiesList: CitiesModel by bindToPreferenceField(
    CitiesModel(), "cities"
)