package com.unsa.persistence.di

import android.content.Context
import androidx.room.Room
import com.unsa.persistence.core.Constants.Companion.APPLICATION_DATABASE
import com.unsa.persistence.data.database.ApplicantsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ApplicantsDatabase::class.java, APPLICATION_DATABASE).allowMainThreadQueries().build()
    @Singleton
    @Provides
    fun provideApplicantDao(database: ApplicantsDatabase) =
        database.getApplicantDao()
    @Singleton
    @Provides
    fun provideUserDao(database: ApplicantsDatabase) =
        database.getUserDao()
}