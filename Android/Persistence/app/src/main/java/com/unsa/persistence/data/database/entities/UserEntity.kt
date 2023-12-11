package com.unsa.persistence.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unsa.persistence.data.model.User

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "password") val password: String
)

fun User.toDatabase() = UserEntity(id, name, password)