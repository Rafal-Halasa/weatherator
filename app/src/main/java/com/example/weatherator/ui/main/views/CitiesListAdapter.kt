package com.example.weatherator.ui.main.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherator.data.models.cities.CitiesModel
import com.example.weatherator.data.models.cities.CitiesModelItem
import com.example.weatherator.databinding.ListCitiesItemBinding
import com.example.weatherator.ui.main.ItemListener

class CitiesListAdapter(
    var cities: CitiesModel,
    val listener: ItemListener
) :
    RecyclerView.Adapter<CitiesListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ListCitiesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cities[position],listener)
    }

    class ViewHolder(private val listItemView: ListCitiesItemBinding) :
        RecyclerView.ViewHolder(listItemView.root) {
        fun bind(
            citiesModelItem: CitiesModelItem,
            listener: ItemListener
        ) {
            listItemView.setVariable(BR.model, citiesModelItem)
            listItemView.setVariable(BR.listener, listener)
        }
    }
}