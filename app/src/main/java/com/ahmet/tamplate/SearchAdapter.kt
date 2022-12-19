package com.ahmet.tamplate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val mContext: Context, private val filmlerListesi: ArrayList<Kategoriler>)
    : RecyclerView.Adapter<SearchAdapter.CardTasarimNesneleriniTutucu>()
{
    inner class CardTasarimNesneleriniTutucu(view: View):RecyclerView.ViewHolder(view){
        var aramaList: LinearLayout
        var aramaFilmTitle: TextView



        init {

            aramaList =view.findViewById(R.id.aramaList)
            aramaFilmTitle = view.findViewById(R.id.aramaFilmTitle)


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.search_film_tasarim,parent,false)
        return CardTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        val film = filmlerListesi[position]

        var tarih = film.releaseDate.split("-").toTypedArray()
        var yıl = tarih[0]
        holder.aramaFilmTitle.text = film.title + "(" + yıl + ")"
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}