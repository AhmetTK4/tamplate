package com.ahmet.tamplate

import android.widget.ImageView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Kategoriler (@SerializedName("title")
                        @Expose
                        var title:String,
                        @SerializedName("id")
                        @Expose
                        var id:Int,
                        @SerializedName("overview")
                        @Expose
                        var overview:String,
                        @SerializedName("poster_path")
                        @Expose
                        var posterPath:String,
                        @SerializedName("backdrop_path")
                        @Expose
                        var backdrop_path:String,
                        @SerializedName("vote_average")
                        @Expose
                        var vote_average:String,
                        @SerializedName("release_date")
                        @Expose
                        var releaseDate: String): Serializable{
}