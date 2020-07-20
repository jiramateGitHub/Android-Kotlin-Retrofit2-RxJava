package com.example.retrofit2jsonkotlin

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t2 = findViewById<View>(R.id.textView) as TextView
        t2.text = "http://192.168.228.146:8080/api/BillPayment/inquiry?txnType=0100&bankChannel=ENET&bankRef=020D16092145056&timestamp=20200416053931&bankCode=025&accountNo=9999999999&refNo1=B000000027&refNo2=200700433&amount=1560000"
        t2.movementMethod = LinkMovementMethod.getInstance()

        recyclerView = findViewById<RecyclerView>(R.id.movie_list)
        recyclerView!!.layoutManager =  LinearLayoutManager(this);

        val client = OkHttpClient.Builder()
            .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS))
            .build()
        val url = "https://192.168.228.146:8080/api/BillPayment/"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(url)
            .client(client)
            .build()

        val postsApi = retrofit.create(INetworkAPI::class.java)
        val response = postsApi.getAllPosts("B000000027","200700433")
        Log.d("getAllPosts", response.toString())
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
//            recyclerView!!.adapter = MovieAdapter(it, this)
        }
    }


}