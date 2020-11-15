package com.example.weatherator.data.models.weather

import android.os.Parcel
import android.os.Parcelable

data class WeatherModel(
    val base: String?,
    val clouds: Clouds?,
    val cod: Int,
    val coord: Coord?,
    val dt: Int,
    val id: Int,
    val main: Main?,
    val name: String?,
    val sys: Sys?,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>?,
    val wind: Wind?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Clouds::class.java.classLoader),
        parcel.readInt(),
        parcel.readParcelable(Coord::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Main::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Sys::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.createTypedArrayList(Weather),
        parcel.readParcelable(Wind::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(base)
        parcel.writeParcelable(clouds, flags)
        parcel.writeInt(cod)
        parcel.writeParcelable(coord, flags)
        parcel.writeInt(dt)
        parcel.writeInt(id)
        parcel.writeParcelable(main, flags)
        parcel.writeString(name)
        parcel.writeParcelable(sys, flags)
        parcel.writeInt(timezone)
        parcel.writeInt(visibility)
        parcel.writeTypedList(weather)
        parcel.writeParcelable(wind, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherModel> {
        override fun createFromParcel(parcel: Parcel): WeatherModel {
            return WeatherModel(
                parcel
            )
        }

        override fun newArray(size: Int): Array<WeatherModel?> {
            return arrayOfNulls(size)
        }
    }
}