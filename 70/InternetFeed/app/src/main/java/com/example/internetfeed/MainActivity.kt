package com.example.internetfeed

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject


class MainActivity : AppCompatActivity() {

    var request: Disposable? = null

    lateinit var vText: TextView
    lateinit var vList: LinearLayout
    lateinit var vRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vRecView = findViewById(R.id.act1_recView)

        val url =
            "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Ffeeds.bbci.co.uk%2Fnews%2Frss.xml"

        val o = createRequest(url).map { Gson().fromJson(it, FeedAPI::class.java) }.subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())

        request = o.subscribe({

            val feed = Feed(
                it.items.mapTo(
                    RealmList<FeedItem>(),
                    { feedItemAPI ->
                        FeedItem(
                            feedItemAPI.title,
                            feedItemAPI.link,
                            feedItemAPI.thumbnail,
                            feedItemAPI.description
                        )
                    }
                )
            )
            Log.e("path", Realm.getDefaultInstance().path)

            Realm.getDefaultInstance().executeTransaction { realm ->

                val oldList = realm.where(Feed::class.java).findAll()
                if (oldList.size > 0) {
                    for (item in oldList) {
                        item.deleteFromRealm()
                    }
                }

                realm.copyToRealm(feed)

            }

            showRecView()
        }, {
            Log.e("test", "", it)
            showRecView()
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    fun showRecView() {

        Realm.getDefaultInstance().executeTransaction { realm ->
            val feed = realm.where(Feed::class.java).findFirst()
            if (feed != null) {
                vRecView.adapter = RecAdapter(feed.items)
                vRecView.layoutManager = LinearLayoutManager(this)
            }
        }
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

class FeedAPI(
    val items: ArrayList<FeedItemAPI>
)

class FeedItemAPI(
    val title: String,
    val link: String,
    val thumbnail: String,
    val description: String
)

open class Feed(
    var items: RealmList<FeedItem> = RealmList<FeedItem>()
) : RealmObject()

open class FeedItem(
    var title: String = "",
    var link: String = "",
    var thumbnail: String = "",
    var description: String = ""
) : RealmObject()

class RecAdapter(val items: RealmList<FeedItem>) : RecyclerView.Adapter<RecHolder>() {
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

        holder.bind(item!!)
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

        //Picasso.with(vThumb.context).load(item.thumbnail).into(vThumb)

        itemView.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(item.link)
            vThumb.context.startActivity(i)
        }
    }
}
