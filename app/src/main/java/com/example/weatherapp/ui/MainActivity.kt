package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.data.api.ApiClient
import com.example.weatherapp.data.api.ApiInterface
import com.example.weatherapp.models.WeatherResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchWeather()
    }

    private fun fetchWeather() {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)

        //Searching for cities around Nairobi
        val call = apiClient.getWeather("1.2921", "36.8219", "08aa22bc0a3895c771f7f91ffa36ad96")

        call.enqueue(object : Callback<WeatherResponse> {

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("Weather", t.message.toString())
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    progress.visibility = View.GONE
                    recylerview.layoutManager = LinearLayoutManager(this@MainActivity)
                    recylerview.adapter = WeatherAdapter(response.body()!!.list)
                } else {
                    Log.d("Weather", response.errorBody().toString())
                }
            }

        })


    }
}