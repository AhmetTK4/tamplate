package com.ahmet.tamplate

import retrofit2.Call
import retrofit2.http.GET

interface DetaylarDaoInterface {

    @GET("movie/now_playing?api_key=ad10474435ba2183e949a5142b518481")
    fun tumDetaylar(): Call<KategorilerCevap>
}