package com.unsa.gretting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import android.os.Bundle
import android.util.Log

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gretting)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etName = findViewById<AppCompatEditText>(R.id.etName)
        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                Log.i("Angel", "Button Pressed: ${name}")
                val intent : Intent = Intent(this, HelloActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }
    }
}