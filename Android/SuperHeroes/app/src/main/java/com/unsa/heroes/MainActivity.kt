package com.unsa.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsa.heroes.adapter.SuperHeroAdapter
import com.unsa.heroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var superHeroMutableList: MutableList<SuperHero> = SuperHeroProvider.superHeroes.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    private val manager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        val decorator = DividerItemDecoration(this, manager.orientation)
        adapter = SuperHeroAdapter (
            superHeroes =  superHeroMutableList,
            onClickListener = { superHero -> onSuperHeroSelected(superHero) },
            deleteListener = { position -> onSuperHeroDelete(position) }
        )
        binding.rvSuperHeroes.layoutManager = manager
        binding.rvSuperHeroes.adapter = adapter
        binding.rvSuperHeroes.addItemDecoration(decorator)
        binding.btnSuperHeroAdd.setOnClickListener { onSuperHeroAdd() }
    }
    private fun onSuperHeroSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.name, Toast.LENGTH_LONG).show()
    }
    private fun onSuperHeroDelete(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
    private fun onSuperHeroAdd() {
        val newSuperHero = SuperHero (
            "Unknown",
            "Unknown",
            "Unknown",
            "https://liquipedia.net/commons/images/thumb/f/f0/Incognito_Logo_V3_Black_Border.png/600px-Incognito_Logo_V3_Black_Border.png"
        )
        superHeroMutableList.add(0, newSuperHero)
        adapter.notifyItemInserted(0)
        manager.scrollToPositionWithOffset(0, 20)
    }
}