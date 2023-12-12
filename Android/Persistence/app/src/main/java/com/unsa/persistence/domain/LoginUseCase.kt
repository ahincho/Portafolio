package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    operator fun invoke(user: User): Boolean {
        return repository.getAllUsers().contains(user)
    }
}