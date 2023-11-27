package com.unsa.applicants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
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
    private fun onCheckCredentials() {
        if (binding.etLoginName.text.isNotEmpty() && binding.etLoginPassword.text.isNotEmpty()) {
            val user = User(binding.etLoginName.text.toString(), binding.etLoginPassword.text.toString())
            if (UserProvider.users.contains(user)) {
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
        cleanField(binding.etLoginName)
        cleanField(binding.etLoginPassword)
    }
    private fun cleanField(field: EditText) {
        field.text = Editable.Factory.getInstance().newEditable("")
    }
}