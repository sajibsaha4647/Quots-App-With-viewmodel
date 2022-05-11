package com.example.androidquotsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainviewModel:MainviewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainviewModel = ViewModelProvider(this,MainviewModelFactory(application)).get(MainviewModel::class.java)

    }
}