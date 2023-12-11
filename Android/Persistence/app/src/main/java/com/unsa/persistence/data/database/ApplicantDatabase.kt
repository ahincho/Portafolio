package com.unsa.persistence.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unsa.persistence.data.database.daos.ApplicantDao
import com.unsa.persistence.data.database.entities.ApplicantEntity

@Database(entities = [ApplicantEntity::class], version = 1)
abstract class ApplicantDatabase : RoomDatabase() {
    abstract fun getApplicantDao(): ApplicantDao
}