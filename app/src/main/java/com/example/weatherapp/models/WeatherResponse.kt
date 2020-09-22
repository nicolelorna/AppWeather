package com.example.weatherapp.models

data class WeatherResponse(
    val cod: String,
    val count: Int,
    val list: List<City>,
    val message: String
)