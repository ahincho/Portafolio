package com.unsa.persistence.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.persistence.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnAdd.setOnClickListener {
            intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        binding.btnView.setOnClickListener {
            intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
    }
}