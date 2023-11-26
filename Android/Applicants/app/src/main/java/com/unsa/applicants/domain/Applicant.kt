package com.unsa.applicants.domain

data class Applicant (
    val document: String,
    val name: String,
    val lastname: String,
    val birthday: String,
    val school: String,
    val career: String
)