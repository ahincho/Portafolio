package com.unsa.quotations.domain

import com.unsa.quotations.data.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor (
    private val repository: QuoteRepository
) {
    suspend operator fun invoke() = repository.getAllQuotes()
}