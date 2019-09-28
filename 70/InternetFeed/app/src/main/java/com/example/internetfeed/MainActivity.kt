package com.example.internetfeed

import android.content.ClipDescription
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import com.squareup.picasso.Picasso
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
    lateinit var vRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vRecView = findViewById(R.id.act1_recView)

        val url = "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Ffeeds.bbci.co.uk%2Fnews%2Frss.xml"

        val o = createRequest(url).map { Gson().fromJson(it, Feed::class.java) }.subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())

        request = o.subscribe({

            showRecView(it.items)
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

    fun showRecView(feedList: ArrayList<FeedItem>) {
        vRecView.adapter = RecAdapter(feedList)
        vRecView.layoutManager = LinearLayoutManager(this)
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

class RecAdapter(val items: ArrayList<FeedItem>) : RecyclerView.Adapter<RecHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_item, parent, false)

        return RecHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecHolder, position: Int) {
        val item = items[position]

        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}

class RecHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: FeedItem) {
        val vTitle = itemView.findViewById<TextView>(R.id.item_title)
        val vThumb = itemView.findViewById<ImageView>(R.id.item_thumb)
        val vDesc = itemView.findViewById<TextView>(R.id.item_desc)

        vTitle.text = item.title
        vDesc.text = item.description

        Picasso.with(vThumb.context).load(item.thumbnail).into(vThumb)

        itemView.setOnClickListener{
            val i=Intent(Intent.ACTION_VIEW)
            i.data= Uri.parse(item.link)
            vThumb.context.startActivity(i)
        }
    }
}
