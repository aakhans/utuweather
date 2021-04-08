package com.utu.weather.network

import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request().url.newBuilder()
            .addQueryParameter("appid", "c0f79db756e5a5363d354f03925db02a")  // my API Key for testing
            .addQueryParameter("exclude", "hourly,minutely") // exclude details from REST response , which are not required
            .build()

        val request = chain.request().newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}