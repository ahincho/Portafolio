package com.unsa.quotations.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unsa.quotations.data.database.daos.QuoteDao
import com.unsa.quotations.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1, exportSchema = true)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}