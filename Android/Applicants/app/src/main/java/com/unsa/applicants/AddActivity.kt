package com.unsa.applicants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.applicants.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {

    }
}