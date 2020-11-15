package com.example.weatherator.logic

import com.example.weatherator.data.api.RetrofitObject

class IconManager {
    companion object {
        fun getIconUrl(weatherIcon: Int) = "${RetrofitObject.BASE_ICON_URL}${if (weatherIcon < 10) {
            "0$weatherIcon"
        } else {
            "$weatherIcon"
        }}-s.png"
    }
}