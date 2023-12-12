package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.unsa.persistence.data.model.User
import com.unsa.persistence.databinding.ActivityRegisterBinding
import com.unsa.persistence.ui.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            saveUser()
        }
    }
    private fun saveUser() {
        if (binding.etUsername.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
            val name = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val user = User(name, password)
            registerViewModel.insertUserInDatabase(user)
            Toast.makeText(this, "User recorded in Database!", Toast.LENGTH_SHORT).show()
            cleanFields()
        } else {
            Toast.makeText(this, "Please complete all the fields!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun cleanFields() {
        cleanField(binding.etUsername)
        cleanField(binding.etPassword)
    }
    private fun cleanField(field: EditText) {
        field.text = Editable.Factory.getInstance().newEditable("")
    }
}