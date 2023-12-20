package com.unsa.quotations.data

import com.unsa.quotations.data.database.daos.QuoteDao
import com.unsa.quotations.data.database.entities.QuoteEntity
import com.unsa.quotations.data.network.QuoteService
import com.unsa.quotations.domain.model.Quote
import com.unsa.quotations.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor (
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes() {
        quoteDao.deleteAll()
    }
}