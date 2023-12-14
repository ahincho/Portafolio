package com.unsa.persistence.domain

import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.Applicant
import javax.inject.Inject

class GetApplicantsUseCase @Inject constructor (
    private val repository: ApplicationRepository
) {
    operator fun invoke(): List<Applicant> {
        val applicants = repository.getAllApplicants()
        return applicants.ifEmpty {
            emptyList()
        }
    }
}