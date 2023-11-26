package com.unsa.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsa.heroes.adapter.SuperHeroAdapter
import com.unsa.heroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        binding.rvSuperHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHeroes.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroes) { superHero ->
            onSuperHeroSelected (
                superHero
            )
        }
    }
    private fun onSuperHeroSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.name, Toast.LENGTH_LONG).show()
    }
}