package com.unsa.persistence.data.model

import com.unsa.persistence.data.database.entities.ApplicantEntity

data class Applicant (
    val id: Int,
    val document: String,
    val name: String,
    val lastname: String,
    val birthday: String,
    val school: String,
    val career: String
)

fun ApplicantEntity.toDomain() = Applicant(id, document, name, lastname, birthday, school, career)