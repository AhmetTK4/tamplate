package com.ahmet.tamplate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AramaDaoInterface {


    @GET("search/movie?api_key=ad10474435ba2183e949a5142b518481&query=Tom")
    fun tumAramalar(): Call<KategorilerCevap>



}