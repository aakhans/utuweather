package com.utu.weather.model

import com.utu.weather.common.RequestListener
 import com.utu.weather.model.data.forecast.ForecastResponse

interface ForecastModel {
    fun getWeatherForecast(lat: Double,lon: Double,callback: RequestListener<ForecastResponse>)
}