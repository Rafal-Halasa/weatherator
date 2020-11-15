package com.example.weatherator.data.files

import android.content.Context
import android.content.res.AssetManager
import androidx.core.content.ContextCompat
import java.net.URL

class WeatherFileReader : WeatherFileReaderI {
    override fun getFileFrom() {
//        Context.g
        URL("test").file
    }

}

interface WeatherFileReaderI {
    fun getFileFrom()
}