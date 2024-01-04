package com.example.mvvmexample.model

import com.example.mvvmexample.R

class CityDataProvider {
    private val cities= arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.bangkok,1_00_000))
        cities.add(City("Beijing", R.drawable.beijing,2_00_000))
        cities.add(City("LONDON", R.drawable.london,3_00_000))
        cities.add(City("Newyork", R.drawable.newyork,4_00_000))
        cities.add(City("Paris", R.drawable.paris,5_00_000))
        cities.add(City("Rio", R.drawable.rio,6_00_000))
        cities.add(City("Singapore", R.drawable.singapore,7_00_000))
        cities.add(City("Tokiyo", R.drawable.tokyo,8_00_000))
        cities.add(City("Sydney", R.drawable.sydney,9_00_000))
    }

    fun getCities()=cities
}