package com.example.weatherapp.models

import java.io.Serializable

data class Wind(
    val deg: Int,
    val gust: Int,
    val speed: Double
): Serializable