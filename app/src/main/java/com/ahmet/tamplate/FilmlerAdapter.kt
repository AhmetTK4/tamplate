package com.ahmet.tamplate

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso



class FilmlerAdapter(private val mContext: Context, private val filmlerListesi: ArrayList<Kategoriler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimNesneleriniTutucu>()
{

    inner class CardTasarimNesneleriniTutucu(view:View):RecyclerView.ViewHolder(view){
        var film_card:CardView

        var imageViewFilmResim:ImageView
        var textViewFilmBaslik:TextView
        var textViewFilmFiyat:TextView
        var textView:TextView


        init {

            film_card =view.findViewById(R.id.film_card)
            imageViewFilmResim = view.findViewById(R.id.imageViewFilmResim)
            textViewFilmBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFilmFiyat = view.findViewById(R.id.textViewFilmFiyat)
            textView = view.findViewById(R.id.textView)

        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_film_tasarim,parent,false)
        return CardTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        val film = filmlerListesi[position]

        //  holder.imageViewFilmResim.
        val url = "https://image.tmdb.org/t/p/w500${film.posterPath}"

        Picasso.get().load(url).into(holder.imageViewFilmResim)
        holder.textView.text = "${film.releaseDate}"
        var tarih = film.releaseDate.split("-").toTypedArray()
        var y??l = tarih[0]
        holder.textViewFilmBaslik.text = film.title + "(" + y??l + ")"
        holder.textViewFilmFiyat.text = "${film.overview}"



            Log.e("filmid", film.id.toString())

            holder.imageViewFilmResim.setImageResource(
                mContext.resources.getIdentifier(film.title, "drawable", mContext.packageName)

            )



        holder.film_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)
        }


        }
    }