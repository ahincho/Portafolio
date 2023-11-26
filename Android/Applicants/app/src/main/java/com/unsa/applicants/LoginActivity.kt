package com.unsa.applicants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.unsa.applicants.databinding.ActivityLoginBinding
import com.unsa.applicants.domain.User
import com.unsa.applicants.providers.UserProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            onCheckCredentials()
        }
    }
    private fun onCheckCredentials(): Boolean {
        if (binding.etLoginName.text.isNotEmpty() && binding.etLoginPassword.text.isNotEmpty()) {
            val user = User(binding.etLoginName.text.toString(), binding.etLoginPassword.text.toString())
            Log.i("Angel", "Login: ${UserProvider.users.contains(user)}")
            return UserProvider.users.contains(user)
        }
        return false
    }
}