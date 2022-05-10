package com.example.androidquotsapp

import androidx.lifecycle.ViewModel

class MainviewModel:ViewModel() {

    private var quotesList: Array<Quote> = emptyArray()
    private var index = 0

}