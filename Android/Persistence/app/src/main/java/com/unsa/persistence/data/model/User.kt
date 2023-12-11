package com.unsa.persistence.data.model

import com.unsa.persistence.data.database.entities.UserEntity

data class User (
    val id: Int,
    val name: String,
    val password: String
)

fun UserEntity.toDomain() = User(id, name, password)