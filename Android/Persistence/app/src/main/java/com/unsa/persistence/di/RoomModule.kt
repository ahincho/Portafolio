package com.unsa.persistence.di

import android.content.Context
import androidx.room.Room
import com.unsa.persistence.data.database.ApplicationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    private val APPLICANTS_DATABASE_NAME = "applicants_db"
    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ApplicationDatabase::class.java, APPLICANTS_DATABASE_NAME).build()
    @Singleton
    @Provides
    fun providesApplicantDao(database: ApplicationDatabase) = database.getApplicantDao()
    @Singleton
    @Provides
    fun providesUserDao(database: ApplicationDatabase) = database.getUserDao()
}