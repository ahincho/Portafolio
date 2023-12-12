package com.unsa.persistence.data

import com.unsa.persistence.data.database.daos.ApplicantDao
import com.unsa.persistence.data.database.entities.toDatabase
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.data.model.toDomain
import javax.inject.Inject

class ApplicationRepository @Inject constructor (
    private val applicantDao: ApplicantDao
) {
    fun getAllApplicants(): List<Applicant> {
        return applicantDao.getAllApplicants().map { it.toDomain() }
    }
    fun insertApplicant(applicant: Applicant) {
        applicantDao.insertApplicant(applicant.toDatabase())
    }
}