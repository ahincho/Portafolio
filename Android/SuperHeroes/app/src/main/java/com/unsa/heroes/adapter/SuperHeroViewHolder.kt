package com.unsa.heroes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.unsa.heroes.SuperHero
import com.unsa.heroes.databinding.ItemSuperHeroBinding

class SuperHeroViewHolder(view: View): ViewHolder(view) {
    val binding = ItemSuperHeroBinding.bind(view)
    fun renderSuperHero(superHero: SuperHero) {
        Glide.with(binding.ivSuperHeroImage.context).load(superHero.photo).into(binding.ivSuperHeroImage)
        binding.tvSuperHeroAlias.text = superHero.alias
        binding.tvSuperHeroName.text = superHero.name
        binding.tvSuperHeroPublisher.text = superHero.publisher
    }
}