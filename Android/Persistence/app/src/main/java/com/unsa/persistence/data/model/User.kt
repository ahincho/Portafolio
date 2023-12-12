package com.unsa.persistence.data.model

import com.unsa.persistence.data.database.entities.UserEntity

data class User (val id: Int, val name: String, val password: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User
        if (name != other.name) return false
        if (password != other.password) return false
        return true
    }
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}

fun UserEntity.toDomain() = User(id, name, password)