package com.unsa.quotations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsa.quotations.databinding.ActivityQuoteBinding

class QuoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_quote)
    }
}