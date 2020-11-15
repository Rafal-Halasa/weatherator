package com.example.weatherator.logic

import com.example.weatherator.R

object TemperatureRange {
    private const val MIN_MID_TEMPERATURE = 10.0
    private const val MAX_MID_TEMPERATURE = 20.0
    fun getColorByTemperature(temp: Double) =
        when {
            temp < MIN_MID_TEMPERATURE -> {
               R.color.colorCold
            }
            temp < MAX_MID_TEMPERATURE -> {
                R.color.colorMid
            }
            else -> {
                R.color.colorHot
            }
        }
}