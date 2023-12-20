package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import com.unsa.quotations.data.database.entities.toDatabase
import com.unsa.quotations.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor (
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}