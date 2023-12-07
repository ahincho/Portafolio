package com.unsa.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace<FirstFragment>(R.id.flContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}