package com.example.weatherator.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherator.data.repository.WeatherRepository
import com.example.weatherator.logic.IconManager
import com.example.weatherator.logic.TemperatureRange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetailViewModel(args: DetailFragmentArgs) : ViewModel() {
    val city: LiveData<String> = MutableLiveData<String>().apply {
        value = args.LocalizedName
    }
    val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description
    var _temperature = MutableLiveData<String>()
    val _temperatureIconColor = MutableLiveData<Int>()
    val temperature: LiveData<String> = _temperature
    val temperatureIconColor: LiveData<Int> = _temperatureIconColor
    val _imgWeatherUrl = MutableLiveData<String>()
    val imgWeatherUrl: LiveData<String> = _imgWeatherUrl


    fun checkWeather(cityId: String) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var wether = WeatherRepository().getCurrentByCityName(cityId).first()
                val temperature = wether.Temperature.Metric.Value
                _temperature.postValue(temperature.toString())
                _temperatureIconColor.postValue(TemperatureRange.getColorByTemperature(temperature))
                _description.postValue(wether.WeatherText)
                _imgWeatherUrl.postValue(IconManager.getIconUrl(wether.WeatherIcon))
                println("city")
                println(wether)
            } catch (exception: HttpException) {
                println(exception)
            }
        }

    init {
        checkWeather(args.cityId)
    }

}