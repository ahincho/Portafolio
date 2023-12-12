package com.unsa.persistence.core

class Constants {
    companion object {
        // Room Database
        const val APPLICATION_DATABASE = "laboratory"
        // Room Tables
        const val APPLICANTS_TABLE = "applicants"
        const val USERS_TABLE = "users"
        // Applicant Fields
        const val APPLICANT_ID = "id"
        const val APPLICANT_DOCUMENT = "document"
        const val APPLICANT_NAME = "name"
        const val APPLICANT_LASTNAME = "lastname"
        const val APPLICANT_BIRTHDAY = "birthday"
        const val APPLICANT_SCHOOL = "school"
        const val APPLICANT_CAREER = "career"
        // User Fields
        const val USER_ID = "id"
        const val USER_NAME = "name"
        const val USER_PASSWORD = "password"
    }
}