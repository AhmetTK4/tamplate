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

class BenzerAdapter(private val mContext: Context, private val filmlerListesi: ArrayList<Kategoriler>)
    : RecyclerView.Adapter<BenzerAdapter.CardTasarimNesneleriniTutucu>()

{

    inner class CardTasarimNesneleriniTutucu(view: View) : RecyclerView.ViewHolder(view) {
        var card_detail: CardView

        var imageView3: ImageView
        var textView2: TextView


        init {

            card_detail = view.findViewById(R.id.card_detail)
            imageView3 = view.findViewById(R.id.imageView3)
            textView2 = view.findViewById(R.id.textView2)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.detail_film_tasarim,parent,false)
        return CardTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        val film = filmlerListesi[position]

        //  holder.imageViewFilmResim.
        val url = "https://image.tmdb.org/t/p/w500${film.posterPath}"

        Picasso.get().load(url).into(holder.imageView3)

        var tarih = film.releaseDate.split("-").toTypedArray()
        var yıl = tarih[0]
        holder.textView2.text = film.title + "(" + yıl + ")"

        holder.imageView3.setImageResource(
            mContext.resources.getIdentifier(film.title, "drawable", mContext.packageName)

        )

        holder.card_detail.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)
        }




    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}