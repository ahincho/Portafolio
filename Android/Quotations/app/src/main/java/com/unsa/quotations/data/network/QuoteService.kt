package com.unsa.quotations.data.network

import com.unsa.quotations.core.RetrofitHelper
import com.unsa.quotations.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor (
    private val apiClient: QuoteApiClient
) {
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}