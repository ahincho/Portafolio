package com.unsa.heroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsa.heroes.R
import com.unsa.heroes.SuperHero

class SuperHeroAdapter(private val superHeroes : List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_super_hero, parent, false))
    }
    override fun getItemCount(): Int {
        return superHeroes.size
    }
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val superHero = superHeroes[position]
        holder.renderSuperHero(superHero)
    }
}