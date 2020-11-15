package com.example.weatherator.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.weatherator.data.api.LocationApi
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.weather_new.WeatherModel
import com.example.weatherator.data.repository.LocationRepository
import com.example.weatherator.data.repository.Repository
import com.example.weatherator.data.repository.WeatherRepository
import com.example.weatherator.ui.base.SingleLiveData
import com.example.weatherator.ui.base.isCityValid
import com.example.weatherator.ui.main.views.CitiesListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var _showDetailViewEvent = SingleLiveData<Int>()
    val showDetailViewEvent: LiveData<Int> get() = _showDetailViewEvent
//    private var _citiesAdapter = SingleLiveData<CitiesListAdapter>().apply {
//        value = CitiesListAdapter(
//            CitiesModel()
//        )
//    }
//    val citiesAdapter: LiveData<CitiesListAdapter> get() = _citiesAdapter

    private var _cities = SingleLiveData<CitiesModel>().apply { value = CitiesModel() }
    val cities: LiveData<CitiesModel> get() = _cities
    fun onFindCityClick(city: String) {
        if (city.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val byCityName = LocationRepository().getCities(city)
                    println(byCityName)

                    _cities.postValue(byCityName)
                } catch (exception: HttpException) {
                    println(exception)

                }
            }
        }
    }

    fun onCityTextChanged(text: CharSequence) {

    }
}