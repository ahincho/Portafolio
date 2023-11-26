package com.unsa.applicants.providers

import com.unsa.applicants.domain.User

class UserProvider {
    companion object {
        var users: MutableList<User> = mutableListOf(
            User("Admin", "admin"),
            User("Teacher", "teacher"),
            User("Angel", "angel")
        )
    }
}