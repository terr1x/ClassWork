package com.example.internetfeed

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val vButton=findViewById<Button>(R.id.act2_button)
        vButton.setOnClickListener{
            finish()
        }
    }
}