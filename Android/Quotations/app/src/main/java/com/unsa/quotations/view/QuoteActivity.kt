package com.unsa.quotations.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.unsa.quotations.R
import com.unsa.quotations.databinding.ActivityQuoteBinding
import com.unsa.quotations.viewmodel.QuoteViewModel

class QuoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuoteBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        binding.vwContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}