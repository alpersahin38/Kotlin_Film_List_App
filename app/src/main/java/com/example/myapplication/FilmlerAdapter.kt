package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context, private val filmlerListesi: List<Filmler>) :
    RecyclerView.Adapter<FilmlerAdapter.CardTasarimNesneleriniTutucu>() {

    inner class CardTasarimNesneleriniTutucu(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewFilm: ImageView
        var textViewFilmBaslik: TextView
        var textViewFilmFiyat: TextView
        var buttonSepeteEkle: Button

        init {
            imageViewFilm = view.findViewById(R.id.imageViewFilm)
            textViewFilmBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFilmFiyat = view.findViewById(R.id.textViewFilmFiyat)
            buttonSepeteEkle = view.findViewById(R.id.buttonSepeteEkle)


        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimNesneleriniTutucu {
        val tasarım =
            LayoutInflater.from(mContext).inflate(R.layout.card_film_tasasrim, parent, false)
        return CardTasarimNesneleriniTutucu(tasarım)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        val film = filmlerListesi[position]
        holder.textViewFilmBaslik.text = film.film_ad
        holder.textViewFilmFiyat.text = "${film.film_fiyat} TL"
        holder.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(
                film.film_resim_ad,
                "drawable",
                mContext.packageName
            )
        )
        holder.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(mContext, "${film.film_ad} sepete eklendi", Toast.LENGTH_SHORT).show()
        }
    }
}