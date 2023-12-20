package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import com.unsa.quotations.data.model.QuoteModel
import com.unsa.quotations.data.model.QuoteProvider
import com.unsa.quotations.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor (
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val random = (quotes.indices).random()
            return quotes[random]
        }
        return null
    }
}