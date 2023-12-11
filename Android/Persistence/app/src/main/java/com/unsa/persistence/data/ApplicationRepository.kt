package com.unsa.persistence.data

import com.unsa.persistence.data.database.daos.ApplicantDao
import com.unsa.persistence.data.database.daos.UserDao
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.data.model.toDomain
import javax.inject.Inject

class ApplicationRepository @Inject constructor (
    private val applicantDao: ApplicantDao,
    private val userDao: UserDao
) {
    suspend fun getAllApplicants(): List<Applicant> {
        val response = applicantDao.getAllApplicants()
        return response.map { it.toDomain() }
    }
}