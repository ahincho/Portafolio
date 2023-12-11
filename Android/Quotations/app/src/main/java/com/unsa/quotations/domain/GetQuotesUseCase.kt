package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import com.unsa.quotations.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor() {
    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}