package com.example.mvvmexample.view

import CityViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.R
import com.example.mvvmexample.databinding.ActivityMainBinding


class MainActivity :  ComponentActivity(){

    private val model:CityViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//     setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cityName.text = "ajda"



    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this) { city ->
            Log.e("city_name",""+city.name);
            binding.cityImg.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    city.img,
                    applicationContext.theme
                )
            )
            binding.cityName.text = city.name
            binding.cityPopulation.text = city.population.toString()
        }
    }
}

