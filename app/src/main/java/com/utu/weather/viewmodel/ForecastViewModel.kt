package com.utu.weather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utu.weather.common.RequestListener
import com.utu.weather.model.ForecastModel
import com.utu.weather.model.data.forecast.ForecastData
import com.utu.weather.model.data.forecast.ForecastResponse
import com.utu.weather.util.kelvinToCelsius
import com.utu.weather.util.unixTimestampToDateDayFormat


class ForecastViewModel : ViewModel() {

    val weatherForecastFailureLiveData = MutableLiveData<String>()
    val progressBarLiveData = MutableLiveData<Boolean>()
    val weatherForecastLiveData = MutableLiveData<ForecastData>()


    fun getWeatherForecast(lat: Double,lon: Double, model: ForecastModel) {

        progressBarLiveData.postValue(true)

        model.getWeatherForecast(lat,lon, object :
                RequestListener<ForecastResponse> {
            override fun onRequestSuccess(data: ForecastResponse) {

                // prepare ForecastData object to be shown on UI
                val forecastData = ForecastData(

                    temperature = "${data.current.temp.kelvinToCelsius().toString()}˚",
                    min_max_temp="${data.daily[0].temp.max.kelvinToCelsius().toString()}˚ / ${data.daily[0].temp.min.kelvinToCelsius().toString()}˚",
                    weather = data.daily[0].weather[0].description,

                    date1 = data.daily[1].dt.unixTimestampToDateDayFormat(),
                    icon1  ="",
                    temp1 = "${data.daily[1].temp.max.kelvinToCelsius().toString()}˚ / ${data.daily[1].temp.min.kelvinToCelsius().toString()}˚",

                    date2 = data.daily[2].dt.unixTimestampToDateDayFormat(),
                    icon2  ="",
                    temp2 = "${data.daily[2].temp.max.kelvinToCelsius().toString()}˚ / ${data.daily[2].temp.min.kelvinToCelsius().toString()}˚",

                    date3 = data.daily[3].dt.unixTimestampToDateDayFormat(),
                    icon3 ="",
                    temp3 = "${data.daily[3].temp.max.kelvinToCelsius().toString()}˚ / ${data.daily[3].temp.min.kelvinToCelsius().toString()}˚"


                )

                progressBarLiveData.postValue(false)

                // post success event
                weatherForecastLiveData.postValue(forecastData)
            }

            override fun onRequestFailed(errorMessage: String) {
                progressBarLiveData.postValue(false)
                weatherForecastFailureLiveData.postValue(errorMessage)
            }
        })
    }
}