package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    suspend operator fun invoke(user: User): Boolean {
        val users = repository.getAllUsers()
        return if (users.isNotEmpty()) {
            users.contains(user)
        } else {
            false
        }
    }
}