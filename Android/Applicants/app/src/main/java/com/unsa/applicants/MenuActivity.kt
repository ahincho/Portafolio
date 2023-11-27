package com.unsa.applicants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.applicants.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnApplicantAdd.setOnClickListener {
            intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        binding.btnApplicantList.setOnClickListener {
            intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}