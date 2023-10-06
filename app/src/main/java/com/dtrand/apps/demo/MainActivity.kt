package com.dtrand.apps.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {

    private var callback : API.Callback ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val retrofit = Retrofit.Builder()
            .baseUrl("https://random.dog/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        callback = retrofit.create(API.Callback::class.java)


        findViewById<View>(R.id.actionBtn).setOnClickListener {

           val txt =    findViewById<TextView>(R.id.displayText)

            callback?.fetch()?.enqueue(object : Callback<API.Modal> {
                override fun onResponse(call: Call<API.Modal>, response: Response<API.Modal>) {
                    if (response.isSuccessful) {
                        txt.text = "Response : \nbytes:[${response.body()!!.fileSizeBytes}]\nUrl:[${response.body()!!.url}]"
                    }
                }

                override fun onFailure(call: Call<API.Modal>, t: Throwable) {
                    t.printStackTrace()
                }
            })

        }

    }
}