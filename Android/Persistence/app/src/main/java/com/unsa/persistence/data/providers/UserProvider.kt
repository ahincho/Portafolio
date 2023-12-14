package com.unsa.persistence.data.providers

import com.unsa.persistence.data.model.User

class UserProvider {
    companion object {
        private val users = listOf<User> (
            User(1, "Admin", "admin"),
            User(2, "Teacher", "teacher"),
            User(3, "Angel", "angel")
        )
    }
}