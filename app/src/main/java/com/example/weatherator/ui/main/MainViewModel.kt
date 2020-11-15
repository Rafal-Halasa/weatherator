package com.example.weatherator.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.cities.CitiesModelItem
import com.example.weatherator.data.repository.LocationRepository
import com.example.weatherator.ui.base.SingleLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var _showDetailViewEvent = SingleLiveData<MainEventData>()
    val showDetailViewEvent: LiveData<MainEventData> get() = _showDetailViewEvent
    private var _cities = SingleLiveData<CitiesModel>().apply { value = CitiesModel() }
    val cities: LiveData<CitiesModel> get() = _cities
    val itemListener: ItemListener = object : ItemListener {
        override fun onCityClick(modelItem: CitiesModelItem) {
            _showDetailViewEvent.value = MainEventData(modelItem.Key, modelItem.LocalizedName)
        }
    }

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

class MainEventData(val key: String, val localizedName: String)
interface ItemListener {
    fun onCityClick(modelItem: CitiesModelItem)
}