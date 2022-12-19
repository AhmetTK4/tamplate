package com.ahmet.tamplate

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detay.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET


class DetayActivity : AppCompatActivity() {
    private lateinit var filmlerArrayList:ArrayList<Kategoriler>
    private lateinit var adapter3 : BenzerAdapter
    private lateinit var bdi : BenzerlerDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        rvBenzer.setHasFixedSize(true)

        rvBenzer.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        bdi = ApiUtils.getBenzerlerDaoInterface()

        val film = intent.getSerializableExtra("filmNesne") as Kategoriler

        textViewTarih.text = film.releaseDate
        var tarih = film.releaseDate.split("-").toTypedArray()
        var yıl = tarih[0]
        textViewFilmAdı.text = film.title + "(" + yıl + ")"
        textViewDetay.text =film.overview
        textViewOy.text = film.vote_average + "/10"
        val url = "https://image.tmdb.org/t/p/w500${film.backdrop_path}"

        Picasso.get().load(url).into(imageViewDetail)

        tumBenzerler()
    }



    fun tumBenzerler(){

        val film = intent.getSerializableExtra("filmNesne") as Kategoriler


        bdi.tumBenzerler(film.id).enqueue(object : Callback<KategorilerCevap> {

            override fun onResponse(
                call: Call<KategorilerCevap>,
                response: Response<KategorilerCevap>
            ) {
                if (response != null) {
                    val liste = response.body()?.kategoriler

                    adapter3 = BenzerAdapter(this@DetayActivity, liste as ArrayList<Kategoriler>)

                    rvBenzer.adapter = adapter3
                }
            }

            override fun onFailure(call: Call<KategorilerCevap>, t: Throwable) {

            }
        }



        )
    }




}