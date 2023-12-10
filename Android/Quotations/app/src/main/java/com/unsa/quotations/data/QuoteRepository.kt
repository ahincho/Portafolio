package com.unsa.quotations.data

import com.unsa.quotations.data.model.QuoteModel
import com.unsa.quotations.data.model.QuoteProvider
import com.unsa.quotations.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}