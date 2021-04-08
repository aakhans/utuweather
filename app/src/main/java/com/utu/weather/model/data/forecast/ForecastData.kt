package com.utu.weather.model.data.forecast


import com.google.gson.annotations.SerializedName

/**
 * we prepare this object to show weather forecast for all cities
 */
data class ForecastData(
    //main section
    var city: String = "",
    var temperature: String = "0",
    var min_max_temp: String = "",
    var weather: String = "",
    //detail section
    var date1: String = "",
    var icon1: String = "",
    var temp1: String = "",


    var date2: String = "",
    var icon2: String = "",
    var temp2: String = "",


    var date3: String = "",
    var icon3: String = "",
    var temp3: String = ""


)