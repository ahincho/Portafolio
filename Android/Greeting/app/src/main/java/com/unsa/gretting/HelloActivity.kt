package com.unsa.gretting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name : String = intent.extras?.getString("USER_NAME").orEmpty()
        tvResult.text = "Hello $name"
    }
}