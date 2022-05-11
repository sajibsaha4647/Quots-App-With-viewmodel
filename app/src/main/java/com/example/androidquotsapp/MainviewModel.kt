package com.example.androidquotsapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.UTF_8
import kotlin.text.Charsets.UTF_8

class MainviewModel(val context:Context):ViewModel() {

    private var quotesList: Array<QuotesData> = emptyArray()
    private var index = 0

    init {
        quotesList = LoadQuotesLists() 
    }

    private fun LoadQuotesLists():Array<QuotesData> {

        val InputStreem = context.assets.open("quotes.json")
        val size:Int = InputStreem.available()
        val Buffer = ByteArray(size)
        InputStreem.read(Buffer)
        InputStreem.close();
        val json = String(Buffer, Charsets.UTF_8)
        val gson = Gson()
       return  gson.fromJson(json,Array<QuotesData>::class.java)

    }


    fun  getquots() = quotesList[index]
    fun  nextquots() = quotesList[++index]
    fun  previousquots() = quotesList[--index]

}