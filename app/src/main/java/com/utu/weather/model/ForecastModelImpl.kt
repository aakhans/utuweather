package com.utu.weather.model

import android.content.Context
import com.utu.weather.common.RequestListener
import com.utu.weather.network.APIClient
import com.utu.weather.network.RetroClient
import com.utu.weather.model.data.forecast.ForecastData
import com.utu.weather.model.data.forecast.ForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//implementation for retrofit call -- success & failure scenarios
class ForecastModelImpl(private val context: Context): ForecastModel {

    override fun getWeatherForecast(
        lat: Double,
        lon: Double,
        callback: RequestListener<ForecastResponse>
    ) {
        val apiInterface: APIClient = RetroClient.client.create(APIClient::class.java)
        val call: Call<ForecastResponse> = apiInterface.callApiForWeatherForecast(lat,lon)

        call.enqueue(object : Callback<ForecastResponse> {


            override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                if (response.body() != null)
                    callback.onRequestSuccess(response.body()!!)
                else
                    callback.onRequestFailed(response.message())
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!)
            }
        })
    }
}