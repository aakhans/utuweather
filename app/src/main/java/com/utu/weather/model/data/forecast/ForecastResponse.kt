package com.utu.weather.model.data.forecast

import com.google.gson.annotations.SerializedName


/**
 * this class will be used in UI to show weather data
 */
data class ForecastResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("daily")
    val daily: List<Daily>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int


)