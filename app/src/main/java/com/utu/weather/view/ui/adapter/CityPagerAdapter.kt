package com.utu.weather.view.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.utu.weather.view.ui.fragment.CityFragment

class CityPagerAdapter(val fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int  = 4  // testing with 4 cities  -- this value is hardcodoed for now but will come from citieslist

    override fun createFragment(position: Int): Fragment {
       // create a cityfragment on swipe
        return CityFragment(position,fa)

    }
}