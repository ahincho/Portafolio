package com.unsa.quotations.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unsa.quotations.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes")
    suspend fun getAllQuotes(): List<QuoteEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)
    @Query("DELETE FROM quotes")
    suspend fun deleteAll()
}