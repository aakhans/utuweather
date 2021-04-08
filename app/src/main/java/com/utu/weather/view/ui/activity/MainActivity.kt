package com.utu.weather.view.ui.activity


import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.utu.weather.R
import com.utu.weather.view.ui.adapter.CityPagerAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main);

        // create a view pager here to display weather forcast for all cities.
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager2
        viewPager.adapter = CityPagerAdapter(this)
    }
}
