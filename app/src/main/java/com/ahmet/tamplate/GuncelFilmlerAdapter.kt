package com.ahmet.tamplate

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GuncelFilmlerAdapter(private val mContext: Context, private val filmlerListesi: ArrayList<Kategoriler>)
    : RecyclerView.Adapter<GuncelFilmlerAdapter.CardTasarimNesneleriniTutucu>() {

    inner class CardTasarimNesneleriniTutucu(view: View):RecyclerView.ViewHolder(view){
        var guncel_card:CardView
        var guncel_resim: ImageView
        var guncel_film_ad: TextView
        var guncel_film_aciklama: TextView



        init {
            guncel_card = view.findViewById(R.id.guncel_card)
            guncel_film_ad = view.findViewById(R.id.guncel_film_ad)
            guncel_film_aciklama = view.findViewById(R.id.guncel_film_aciklama)
            guncel_resim = view.findViewById(R.id.guncel_resim)


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.guncel_film_tasarim,parent,false)
        return CardTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        val film = filmlerListesi[position]

        //  holder.imageViewFilmResim.
        val url = "https://image.tmdb.org/t/p/w500${film.backdrop_path}"

        Picasso.get().load(url).into(holder.guncel_resim)
        var tarih = film.releaseDate.split("-").toTypedArray()
        var yıl = tarih[0]
        holder.guncel_film_ad.text = film.title + "(" + yıl + ")"
        holder.guncel_film_aciklama.text = film.overview

        holder.guncel_resim.setImageResource(
            mContext.resources.getIdentifier(film.title, "drawable", mContext.packageName)


        )

        holder.guncel_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}