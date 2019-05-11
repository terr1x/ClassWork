package com.example.internetfeed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vText=findViewById<TextView>(R.id.act1_text)
        vText.setTextColor(0xff4286f4.toInt())
        vText.setOnClickListener{
            Log.e("tag","НАЖАТА КНОПКА!(-_-)")
            val i= Intent(this,SecondActivity::class.java)
            startActivity(i)
        }

        Log.v("tag","Был запущен onCreate")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
