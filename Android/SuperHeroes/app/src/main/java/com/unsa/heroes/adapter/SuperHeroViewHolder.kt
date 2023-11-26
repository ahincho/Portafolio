package com.unsa.heroes.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.unsa.heroes.R
import com.unsa.heroes.SuperHero

class SuperHeroViewHolder(view: View): ViewHolder(view) {
    val superHeroImage = view.findViewById<ImageView>(R.id.ivSuperHeroImage)
    val superHeroAlias = view.findViewById<TextView>(R.id.tvSuperHeroAlias)
    val superHeroName = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val superHeroPublisher = view.findViewById<TextView>(R.id.tvSuperHeroPublisher)
    fun renderSuperHero(superHero: SuperHero) {
        superHeroAlias.text = superHero.alias
        superHeroName.text = superHero.name
        superHeroPublisher.text = superHero.publisher
    }
}