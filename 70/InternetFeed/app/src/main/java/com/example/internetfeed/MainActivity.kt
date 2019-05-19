package com.example.internetfeed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var vText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vText=findViewById<TextView>(R.id.act1_text)
        vText.setTextColor(0xff4286f4.toInt())
        vText.setOnClickListener{
            val i= Intent(this,SecondActivity::class.java)
            i.putExtra("tag1", vText.text)
            startActivityForResult(i,0)
        }

        Log.v("tag","Был запущен onCreate")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data!=null) {
            val str=data.getStringExtra("tag2")

            vText.text=str
        }
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
