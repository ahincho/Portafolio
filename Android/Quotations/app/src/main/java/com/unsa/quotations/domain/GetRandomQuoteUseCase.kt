package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import com.unsa.quotations.data.model.QuoteModel
import com.unsa.quotations.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor() {
    private val repository = QuoteRepository()
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val random = (quotes.indices).random()
            return quotes[random]
        }
        return null
    }
}