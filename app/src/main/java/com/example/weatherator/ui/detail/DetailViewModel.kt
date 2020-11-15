package com.example.weatherator.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherator.data.api.RetrofitObject
import com.example.weatherator.data.repository.WeatherRepository
import com.example.weatherator.logic.TemperatureRange
import com.example.weatherator.ui.base.isCityValid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetailViewModel(args: DetailFragmentArgs) : ViewModel() {
    private val imageSize = 4
//    val weather = args.weatherModel.weather?.first()
//    val main = args.weatherModel.main
//
//    val imgWeatherUrl: LiveData<String> = MutableLiveData<String>().apply {
//        value = "${RetrofitObject.BASE_ICON_URL}${weather?.icon}@${imageSize}x.png"
//    }
//    val description: LiveData<String> =
//        MutableLiveData<String>().apply { value = weather?.description }
//    val city: LiveData<String> =
//        MutableLiveData<String>().apply { value = args.weatherModel.name }
//    val temperature: LiveData<String> =
//        MutableLiveData<String>().apply { value = main?.temp.toString() }
//    val temperatureIconColor: LiveData<Int> =
//        MutableLiveData<Int>().apply {
//            value = main?.temp?.let { TemperatureRange.getColorByTemperature(it) }
//        }
//fun checkWeather(city: String) {
//    if (city.isCityValid()) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val byCityName = WeatherRepository().getByCityName("274231")
//                _showDetailViewEvent.postValue(222)
//                print("das")
//            } catch (exception: HttpException) {
//                exception.code()
//            }
//        }
//
//    }
//}
    init {
        Log.e("tutaj", "arg $args")
    }

}