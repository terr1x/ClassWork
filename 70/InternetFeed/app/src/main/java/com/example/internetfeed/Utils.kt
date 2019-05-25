package com.example.internetfeed

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import java.lang.RuntimeException
import java.net.HttpURLConnection
import java.net.URL

/* created by me */

fun createRequest(url:String)= Observable.create<String> {
    val urlConnection = URL(url).openConnection() as HttpURLConnection
    try {
        urlConnection.connect()

        if (urlConnection.responseCode != HttpURLConnection.HTTP_OK)
            it.onError(RuntimeException(urlConnection.responseMessage))
        else {
            val str = urlConnection.inputStream.bufferedReader().readText()
            it.onNext(str)
        }
    } finally {
        urlConnection.disconnect()
    }

}