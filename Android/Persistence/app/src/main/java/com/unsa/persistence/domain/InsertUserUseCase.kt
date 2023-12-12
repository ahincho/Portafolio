package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.User
import javax.inject.Inject

class InsertUserUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}