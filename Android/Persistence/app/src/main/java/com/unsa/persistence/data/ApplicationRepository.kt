package com.unsa.persistence.data

import com.unsa.persistence.data.database.daos.ApplicantDao
import com.unsa.persistence.data.database.daos.UserDao
import com.unsa.persistence.data.database.entities.toDatabase
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.data.model.User
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
    suspend fun insertApplicant(applicant: Applicant) {
        applicantDao.insertApplicant(applicant.toDatabase())
    }
    suspend fun deleteApplicant(id: Int) {
        applicantDao.deleteApplicantById(id)
    }
    suspend fun getUserByNameAndPassword(name: String, password: String): User {
        val user = userDao.getUserByNameAndPassword(name, password)
        return user.toDomain()
    }
}