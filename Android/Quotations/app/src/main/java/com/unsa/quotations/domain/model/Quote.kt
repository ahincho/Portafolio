package com.unsa.quotations.domain.model

import com.unsa.quotations.data.database.entities.QuoteEntity
import com.unsa.quotations.data.model.QuoteModel

data class Quote (
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)