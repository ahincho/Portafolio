package com.unsa.quotations.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unsa.quotations.domain.model.Quote

@Entity(tableName = "quotes")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "quote")
    val quote: String,
    @ColumnInfo(name = "author")
    val author: String
)

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)