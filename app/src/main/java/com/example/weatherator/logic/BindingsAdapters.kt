package com.example.weatherator.logic

import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherator.BR
import com.example.weatherator.R
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.weather_new.DailyForecast
import com.example.weatherator.databinding.ListWeatherItemBinding
import com.example.weatherator.ui.main.ItemListener
import com.example.weatherator.ui.main.views.CitiesListAdapter


object BindingsAdapters {
    @BindingAdapter(value = ["text_color"])
    @JvmStatic
    fun setTextColor(view: TextView, color: Int) {
        if (color != 0) {
            view.context?.let { ContextCompat.getColor(it, color) }?.let { view.setTextColor(it) }
        }
    }

    @BindingAdapter(value = ["tint_color"])
    @JvmStatic
    fun setImageTintColor(view: ImageView, color: Int) {
        if (color == 0) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
            view.context?.let { ContextCompat.getColor(it, color) }?.let { view.setColorFilter(it) }
        }
    }

    @BindingAdapter(value = ["adapter_value", "listener"], requireAll = false)
    @JvmStatic
    fun setAdapters(
        view: RecyclerView,
        cities: CitiesModel,
        listener: ItemListener
    ) {
        if (view.adapter == null) {
            view.adapter = CitiesListAdapter(CitiesModel(), listener)
            view.layoutManager = LinearLayoutManager(view.context)
        }
        val citiesListAdapter = view.adapter as CitiesListAdapter
        citiesListAdapter.cities = cities
        citiesListAdapter.notifyDataSetChanged()
    }

    @BindingAdapter(value = ["weather_data"])
    @JvmStatic
    fun setScrollWeather(view: HorizontalScrollView, dailyForecast: List<DailyForecast>?) {
        dailyForecast?.forEach {
            val inflate = ListWeatherItemBinding.inflate(LayoutInflater.from(view.context))
            view.findViewById<LinearLayout>(R.id.scroll_view_container).addView(inflate.root)
            inflate.setVariable(BR.weather_model, it)
        }
    }
}