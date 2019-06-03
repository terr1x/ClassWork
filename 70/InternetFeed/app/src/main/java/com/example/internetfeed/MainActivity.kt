package com.example.internetfeed

import android.content.ClipDescription
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import org.w3c.dom.Text
import java.lang.RuntimeException
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    var request: Disposable? = null

    lateinit var vText: TextView
    lateinit var vList: LinearLayout
    lateinit var vListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vListView = findViewById(R.id.act1_listView)

        val url = "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Ffeeds.bbci.co.uk%2Fnews%2Frss.xml"

        val o = createRequest(url).map { Gson().fromJson(it, Feed::class.java) }.subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())

        request = o.subscribe({

            showListView(it.items)
        }, {
            Log.e("test", "", it)
        })
    }

    fun showLineralLayout(feedList: ArrayList<FeedItem>) {
        val inflater = layoutInflater
        for (f in feedList) {
            val view = inflater.inflate(R.layout.list_item, vList, false)
            val vTitle = view.findViewById<TextView>(R.id.item_title)
            vTitle.text = f.title
            vList.addView(view)
        }
    }

    fun showListView(feedList: ArrayList<FeedItem>) {
        vListView.adapter = Adapter(feedList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            val str = data.getStringExtra("tag2")

            vText.text = str
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

class Feed(
    val items: ArrayList<FeedItem>
)

class FeedItem(
    val title: String,
    val link: String,
    val thumbnail: String,
    val description: String
)

class Adapter(val items: ArrayList<FeedItem>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent!!.context)

        val view = convertView ?: inflater.inflate(R.layout.list_item, parent, false)
        val vTitle = view.findViewById<TextView>(R.id.item_title)

        val item = getItem(position) as FeedItem

        vTitle.text = item.title

        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }


}
