package com.unsa.persistence.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unsa.persistence.data.database.daos.ApplicantDao
import com.unsa.persistence.data.database.daos.UserDao
import com.unsa.persistence.data.database.entities.ApplicantEntity
import com.unsa.persistence.data.database.entities.UserEntity

@Database(entities = [ApplicantEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class ApplicantsDatabase : RoomDatabase() {
    abstract fun getApplicantDao(): ApplicantDao
    abstract fun getUserDao(): UserDao
}