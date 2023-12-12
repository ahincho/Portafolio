package com.unsa.persistence.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unsa.persistence.core.Constants.Companion.USERS_TABLE
import com.unsa.persistence.core.Constants.Companion.USER_ID
import com.unsa.persistence.core.Constants.Companion.USER_NAME
import com.unsa.persistence.core.Constants.Companion.USER_PASSWORD
import com.unsa.persistence.data.model.User

@Entity(tableName = USERS_TABLE)
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = USER_ID) val id: Int = 0,
    @ColumnInfo(name = USER_NAME) val name: String,
    @ColumnInfo(name = USER_PASSWORD) val password: String
)

fun User.toDatabase() = UserEntity(name = name, password = password)