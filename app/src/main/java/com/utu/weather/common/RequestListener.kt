package com.utu.weather.common


// request listener interface for retrofit
interface RequestListener<T> {
    fun onRequestSuccess(data: T)
    fun onRequestFailed(errorMessage: String)
}