package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.persistence.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}