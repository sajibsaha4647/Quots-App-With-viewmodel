package com.example.androidquotsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainviewModelFactory :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainviewModel() as T
    }
}