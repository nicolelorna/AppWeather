package com.example.weatherapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.models.City
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherAdapter(private val list: List<City>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.weather_item, parent, false)

        return WeatherViewHolder(view)

    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        val city = list[position]

        holder.itemView.apply {
            this.name.text = city.name
            this.humidity.text = this.context.getString(
                R.string.adapter_item,
                "Humidity", city.main.humidity.toString()
            )
            this.pressure.text = this.context.getString(
                R.string.adapter_item,
                "Pressure", city.main.pressure.toString()
            )
            this.temp.text = this.context.getString(
                R.string.adapter_item,
                "Temperature", city.main.temp.toString()
            )
            this.temp_max.text = this.context.getString(
                R.string.adapter_item,
                "Temperature Max", city.main.temp_max.toString()
            )
            this.temp_min.text = this.context.getString(
                R.string.adapter_item,
                "Temperature Min", city.main.temp_min.toString()
            )

            this.card_view.setOnClickListener {
                val intent = Intent(this.context, WeatherApp::class.java)
                intent.putExtra("city", city)
                this.context.startActivity(intent)
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}