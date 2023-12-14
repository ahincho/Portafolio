package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import javax.inject.Inject

class DeleteApplicantUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    operator fun invoke(id: Int) {
        repository.deleteApplicant(id)
    }
}