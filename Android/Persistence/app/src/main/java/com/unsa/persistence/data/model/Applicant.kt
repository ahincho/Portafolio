package com.unsa.persistence.data.model

data class Applicant (
    val id: Int,
    val document: String,
    val name: String,
    val lastname: String,
    val birthday: String,
    val school: String,
    val career: String
)