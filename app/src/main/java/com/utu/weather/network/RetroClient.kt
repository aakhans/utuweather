package com.utu.weather.network

import com.google.gson.GsonBuilder
import com.utu.weather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import java.util.concurrent.Executors
import retrofit2.converter.gson.GsonConverterFactory

import java.util.logging.Level

object RetroClient {

    private val base_url: String ="http://api.openweathermap.org/data/2.5/"  // hard wired for demo
    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: Retrofit
        get() {
            if (retrofit == null) {
                synchronized(Retrofit::class.java) {
                    if (retrofit == null) {

                        val httpClient = OkHttpClient.Builder()
                            .addInterceptor(APIInterceptor())

                        val client = httpClient.build()

                        retrofit = Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(client)
                            .build()
                    }
                }

            }
            return retrofit!!
        }
}