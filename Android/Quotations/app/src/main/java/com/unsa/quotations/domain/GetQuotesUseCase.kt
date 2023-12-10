package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import com.unsa.quotations.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()
    suspend fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}