package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.persistence.R
import com.unsa.persistence.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}