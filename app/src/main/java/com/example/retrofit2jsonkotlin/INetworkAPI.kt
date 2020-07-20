package com.example.retrofit2jsonkotlin

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.Query

interface INetworkAPI {
    @GET("inquiry?")
    fun getAllPosts(@Query("refNo1") refNo1: String?, @Query("refNo2") refNo2: String?): Observable<List<MoviesModel>>
}