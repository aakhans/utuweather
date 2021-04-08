package com.utu.weather.network

import com.utu.weather.model.data.forecast.ForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIClient {
    @GET("onecall")
    fun callApiForWeatherForecast(@Query("lat") latitude: Double, @Query("lon") longitude: Double): Call<ForecastResponse>
}