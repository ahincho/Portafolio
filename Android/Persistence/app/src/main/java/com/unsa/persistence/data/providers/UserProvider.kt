package com.unsa.persistence.data.providers

import com.unsa.persistence.data.model.User

class UserProvider {
    companion object {
        private val users = listOf<User> (
            User("Admin", "admin"),
            User("Teacher", "teacher"),
            User("Angel", "angel")
        )
    }
}