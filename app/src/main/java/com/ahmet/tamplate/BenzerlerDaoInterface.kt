package com.ahmet.tamplate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BenzerlerDaoInterface {

    @GET("movie/{id}/similar?api_key=ad10474435ba2183e949a5142b518481")
    fun tumBenzerler(@Path("id") id: Int): Call<KategorilerCevap>




}