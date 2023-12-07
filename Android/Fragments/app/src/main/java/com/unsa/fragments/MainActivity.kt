package com.unsa.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView
    private val onNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.firstItem -> {
                supportFragmentManager.commit {
                    replace<FirstFragment>(R.id.flContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.secondItem -> {
                supportFragmentManager.commit {
                    replace<SecondFragment>(R.id.flContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.thirdItem -> {
                supportFragmentManager.commit {
                    replace<ThirdFragment>(R.id.flContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = findViewById(R.id.bnvMenu)
        navigation.setOnNavigationItemSelectedListener(onNavMenu)
        supportFragmentManager.commit {
            replace<FirstFragment>(R.id.flContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}