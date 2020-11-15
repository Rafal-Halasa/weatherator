package com.example.weatherator.ui.main.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherator.R
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.cities.CitiesModelItem

class CitiesListAdapter(var cities: CitiesModel) :
    RecyclerView.Adapter<CitiesListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        val contactView = LayoutInflater.from(parent.context).inflate(R.layout.list_cities_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }


    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    class ViewHolder(val listItemView: View) :
        RecyclerView.ViewHolder(listItemView) {
        fun bind(citiesModelItem: CitiesModelItem) {
            listItemView.findViewById<TextView>(R.id.city).text = citiesModelItem.LocalizedName
        }
    }
}