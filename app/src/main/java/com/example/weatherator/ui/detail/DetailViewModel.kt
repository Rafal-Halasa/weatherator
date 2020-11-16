package com.example.weatherator.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherator.data.models.weather_new.DailyForecast
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
    private var _description = MutableLiveData<String>()
    val description: LiveData<String> = _description
    private var _temperature = MutableLiveData<String>()
    private var _temperatureIconColor = MutableLiveData<Int>()
    val temperature: LiveData<String> = _temperature
    val temperatureIconColor: LiveData<Int> = _temperatureIconColor
    private var _imgWeatherUrl = MutableLiveData<String>()
    val imgWeatherUrl: LiveData<String> = _imgWeatherUrl
    private var _dailyForecasts = MutableLiveData<List<DailyForecast>>()
    val dailyForecasts: LiveData<List<DailyForecast>> = _dailyForecasts

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

    fun check5DaysWeather(cityId: String) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var wether = WeatherRepository().getByCityName(cityId)
                _dailyForecasts.postValue(wether.DailyForecasts)

                println("city")
                println(wether)
            } catch (exception: HttpException) {
                println(exception)
            }
        }

    init {
        checkWeather(args.cityId)
        check5DaysWeather(args.cityId)
    }

}