package com.unsa.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        binding.rvSuperHeroes.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroes)
    }
}