package com.unsa.persistence.data.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unsa.persistence.data.database.entities.ApplicantEntity

@Dao
interface ApplicantDao {
    @Query("SELECT * FROM applicants")
    fun getAllApplicants(): List<ApplicantEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApplicant(applicant: ApplicantEntity)
    @Query("DELETE FROM applicants WHERE id = :id")
    fun deleteApplicant(id: Int)
}