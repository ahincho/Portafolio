package com.unsa.persistence.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unsa.persistence.data.database.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE name = :name AND password = :password")
    suspend fun getUserByNameAndPassword(name: String, password: String): UserEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)
}