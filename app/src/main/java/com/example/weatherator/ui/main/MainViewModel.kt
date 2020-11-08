package com.example.weatherator.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherator.data.models.WeatherModel
import com.example.weatherator.data.repository.Repository
import com.example.weatherator.data.repository.WeatherRepository
import com.example.weatherator.ui.base.SingleLiveData
import com.example.weatherator.ui.base.isCityValid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class MainViewModel : ViewModel() {
    private var _showDetailViewEvent = SingleLiveData<WeatherModel>()
    val showDetailViewEvent: LiveData<WeatherModel> get() = _showDetailViewEvent
    fun checkWeather(city: String) {
        if (city.isCityValid()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    _showDetailViewEvent.value = WeatherRepository().getByName(city)
                } catch (exception: HttpException) {
                    exception.code()
                }
            }

        }
    }

    fun checkWeather(lat: Long, long: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val byLatLong = WeatherRepository().getByLatLong(51.23630, 22.559502)
            } catch (exception: Exception) {
                Log.e("tutaj", "exception $exception")
            }
        }
    }
}