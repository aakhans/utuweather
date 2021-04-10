package com.utu.weather.view.ui.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.utu.weather.R
import com.utu.weather.model.ForecastModel
import com.utu.weather.model.ForecastModelImpl
import com.utu.weather.model.data.forecast.ForecastData
import com.utu.weather.viewmodel.ForecastViewModel
import kotlinx.android.synthetic.main.layout_frag_weather.*


open class CityFragment(): Fragment() {

    private lateinit var model: ForecastModel
    private lateinit var viewModel: ForecastViewModel
    private var position :Int=0

    // sample data
    // i have hardcoded data here, in actual implementation it will be fetched through some API call or from assets folder
    private val latitudes= doubleArrayOf(-37.813999, -33.867851, 56.395222, 35.029499)
    private val longitudes= doubleArrayOf(144.963318, 151.207321, -3.43139, -99.093132)
    private val citynames= arrayOf("Melbourne", "Sydney", "Perth", "Hobart")

    companion object {
            fun newInstance(position: Int): CityFragment {
                val args = Bundle()
                args.putInt("position", position)
                val fragment = CityFragment()
                fragment.arguments = args
                return fragment
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TEST", "== on onCreateView called WeatherFragment")

        return inflater.inflate(R.layout.layout_frag_weather, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        model = ForecastModelImpl(context)

        viewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
    }


    override fun onResume() {
        super.onResume()
        setLiveDataListeners()

        arguments?.getInt("position")?.let {
            position = it
        }

        Log.d("TEST", "======= on Resume called WeatherFragment $position")

        // get weather forecast now
        viewModel.getWeatherForecast(latitudes[position], longitudes[position], model) // fetch weather forecast

    }

    private fun setLiveDataListeners() {

        viewModel.progressBarLiveData.observe(this, Observer { isShowLoader ->
            if (isShowLoader)
                progressBar.visibility = View.VISIBLE
            else
                progressBar.visibility = View.GONE
        })

       //onsuccess -- prepare ForecastData Object

        viewModel.weatherForecastLiveData.observe(this, Observer { weatherForecastData ->
            setForecastData(weatherForecastData)
        })

        // REST API Erroro scenario
        viewModel.weatherForecastFailureLiveData.observe(this, Observer { errorMessage ->

            // data_error_message.visibility = View.VISIBLE
            // data_error_message.text = errorMessage
        })
    }


    private fun setForecastData(forecastData: ForecastData) {

        data_error_message.visibility = View.GONE
        cityname?.text=citynames[position]
        temperature?.text=forecastData.temperature
        weather?.text=forecastData.weather
        minmaxtemp?.text=forecastData.min_max_temp

        date1?.text=forecastData.date1
        icon1?.text=forecastData.icon1  // i have not implemented icons - due to time shortage
        temp1?.text=forecastData.temp1

        date2?.text=forecastData.date2
        icon2?.text=forecastData.icon2
        temp2?.text=forecastData.temp2

        date3?.text=forecastData.date3
        icon3?.text=forecastData.icon3
        temp3?.text=forecastData.temp3

    }
}