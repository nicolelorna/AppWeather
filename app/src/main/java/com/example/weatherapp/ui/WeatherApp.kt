package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.models.City
import kotlinx.android.synthetic.main.activity_weather_app.*
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_app)

        val city = intent.getSerializableExtra("city") as City

        title = city.name

        main_view.apply {
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
        }


    }
}