package com.unsa.persistence.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.unsa.persistence.data.model.User
import com.unsa.persistence.databinding.ActivityLoginBinding
import com.unsa.persistence.ui.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            checkCredentials()
        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun checkCredentials() {
        if (binding.etUser.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
            val name = binding.etUser.text.toString()
            val password = binding.etPassword.text.toString()
            val user = User(0, name, password)
            if (loginViewModel.getSuccessfulLogin(user)) {
                cleanFields()
                intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Credentials are wrong!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please complete all the fields!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun cleanFields() {
        cleanField(binding.etUser)
        cleanField(binding.etPassword)
    }
    private fun cleanField(field: EditText) {
        field.text = Editable.Factory.getInstance().newEditable("")
    }
}