package com.utu.weather.util

import java.text.SimpleDateFormat
import java.util.*

// writing extension functions for Integer and Double
// to be used in preparing fina ForecastData object

fun Int.unixTimestampToDateDayFormat() : String {

    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this*1000.toLong()

        val outputDateFormat = SimpleDateFormat("E, dd MMM", Locale.ENGLISH)
        outputDateFormat.timeZone = TimeZone.getDefault() // Current timezone
        return outputDateFormat.format(calendar.time) // current time

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return this.toString()
}


// convert temperature to Centigrade
fun Double.kelvinToCelsius() : Int {

    return  (this - 273.15).toInt()
}