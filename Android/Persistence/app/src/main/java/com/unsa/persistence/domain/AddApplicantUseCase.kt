package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.Applicant
import javax.inject.Inject

class AddApplicantUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    operator fun invoke(applicant: Applicant) {
        repository.insertApplicant(applicant)
    }
}