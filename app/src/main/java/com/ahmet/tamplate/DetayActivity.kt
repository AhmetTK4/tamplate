package com.ahmet.tamplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*


class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        textViewTarih.text = film.textView
        textViewFilmAdı.text = film.film_ad
        textViewDetay.text =film.filmAciklama
    }


}