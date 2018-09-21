package com.wengelef.lunchmemorykt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.wengelef.lunchmemorykt.di.DaggerLunchComponent
import com.wengelef.lunchmemorykt.di.LunchComponent

class MainActivity : AppCompatActivity(), Injector<LunchComponent>, ComponentProvider<LunchComponent> {

    //private lateinit var lunchComponent: LunchComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun component(): LunchComponent {
        return (application as MainApplication).lunchComponent
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.navigation.signup_graph).navigateUp()
    }
}

interface ComponentProvider<T>{
    fun component(): T
}