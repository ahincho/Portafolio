package com.unsa.persistence.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("applicants")
data class ApplicantEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "document") val document: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "birthday") val birthday: String,
    @ColumnInfo(name = "school") val school: String,
    @ColumnInfo(name = "career") val career: String
)