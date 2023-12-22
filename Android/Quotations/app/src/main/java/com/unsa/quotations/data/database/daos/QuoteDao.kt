package com.unsa.quotations.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unsa.quotations.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): List<QuoteEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(quotes: List<QuoteEntity>)
    @Query("DELETE FROM quotes")
    fun deleteAll()
}