package com.example.weatherator.logic

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.ui.main.views.CitiesListAdapter


object BindingsAdapters {
    @BindingAdapter(value = ["text_color"])
    @JvmStatic
    fun setTextColor(view: TextView, color: Int) {
        view.context?.let { ContextCompat.getColor(it, color) }?.let { view.setTextColor(it) }
    }

    @BindingAdapter(value = ["tint_color"])
    @JvmStatic
    fun setImageTintColor(view: ImageView, color: Int) {
        view.context?.let { ContextCompat.getColor(it, color) }?.let { view.setColorFilter(it) }
    }

    @BindingAdapter(value = ["set_adapter"])
    @JvmStatic
    fun setImageTintColor(
        view: RecyclerView,
        adapter: CitiesListAdapter
    ) {
        view.adapter = adapter
        view.layoutManager = LinearLayoutManager(view.context)
    }

    @BindingAdapter(value = ["set_adapter_value"])
    @JvmStatic
    fun setImageTin(
        view: RecyclerView,
        cities: CitiesModel
    ) {
        if (view.adapter == null) {
            view.adapter = CitiesListAdapter(CitiesModel())
            view.layoutManager = LinearLayoutManager(view.context)
        }
        val citiesListAdapter = view.adapter as CitiesListAdapter
        citiesListAdapter.cities = cities
        citiesListAdapter.notifyDataSetChanged()
    }
}