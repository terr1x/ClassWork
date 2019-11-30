package com.example.internetfeed

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder

class PlayService:Service() {
    var player:MediaPlayer?=null

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player?.stop()
        var url=intent!!.extras?.getString("mp3")
        player= MediaPlayer()
        player?.setDataSource(this, Uri.parse(url))
        player?.setOnPreparedListener{ p ->
            p.start()
        }
        player?.prepareAsync()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}