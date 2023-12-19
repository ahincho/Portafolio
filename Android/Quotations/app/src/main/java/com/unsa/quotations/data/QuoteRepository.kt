package com.unsa.quotations.data

import com.unsa.quotations.data.model.QuoteModel
import com.unsa.quotations.data.model.QuoteProvider
import com.unsa.quotations.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor (
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}