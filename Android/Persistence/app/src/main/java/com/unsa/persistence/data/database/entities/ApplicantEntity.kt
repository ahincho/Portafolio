package com.unsa.persistence.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unsa.persistence.core.Constants.Companion.APPLICANTS_TABLE
import com.unsa.persistence.core.Constants.Companion.APPLICANT_BIRTHDAY
import com.unsa.persistence.core.Constants.Companion.APPLICANT_CAREER
import com.unsa.persistence.core.Constants.Companion.APPLICANT_DOCUMENT
import com.unsa.persistence.core.Constants.Companion.APPLICANT_ID
import com.unsa.persistence.core.Constants.Companion.APPLICANT_LASTNAME
import com.unsa.persistence.core.Constants.Companion.APPLICANT_NAME
import com.unsa.persistence.core.Constants.Companion.APPLICANT_SCHOOL
import com.unsa.persistence.data.model.Applicant

@Entity(tableName = APPLICANTS_TABLE)
data class ApplicantEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = APPLICANT_ID) val id: Int = 0,
    @ColumnInfo(name = APPLICANT_DOCUMENT) val document: String,
    @ColumnInfo(name = APPLICANT_NAME) val name: String,
    @ColumnInfo(name = APPLICANT_LASTNAME) val lastname: String,
    @ColumnInfo(name = APPLICANT_BIRTHDAY) val birthday: String,
    @ColumnInfo(name = APPLICANT_SCHOOL) val school: String,
    @ColumnInfo(name = APPLICANT_CAREER) val career: String
)

fun Applicant.toDatabase() = ApplicantEntity (
    document = document, name = name,
    lastname = lastname, birthday = birthday,
    school = school, career =  career
)