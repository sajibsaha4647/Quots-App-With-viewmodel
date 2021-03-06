package com.example.androidquotsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainviewModel:MainviewModel
    private  val quotestext: TextView get() = findViewById(R.id.quotes)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainviewModel = ViewModelProvider(this,MainviewModelFactory(application)).get(MainviewModel::class.java)
        setQuote(mainviewModel.getquots())

//        println("quotessssssssssssss"+mainviewModel.getquots())

    }

    fun setQuote(quotes:QuotesData){
        quotestext.text = quotes.text

    }

    fun onNext(view: View) {
        setQuote(mainviewModel.nextquots())
        println("press")
    }
    fun onPrevious(view: View) {
        setQuote(mainviewModel.previousquots())
    }

    fun Onshare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,mainviewModel.getquots().text)
        startActivity(intent)
    }

}