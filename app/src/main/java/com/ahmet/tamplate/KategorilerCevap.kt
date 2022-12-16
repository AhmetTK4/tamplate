package com.ahmet.tamplate

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KategorilerCevap (
    @SerializedName("results")
    @Expose
    var kategoriler:List<Kategoriler>){

}