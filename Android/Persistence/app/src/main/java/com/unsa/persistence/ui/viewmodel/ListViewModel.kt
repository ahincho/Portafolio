package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.unsa.persistence.data.ApplicationRepository
import com.unsa.persistence.data.model.Applicant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (
    private val repository: ApplicationRepository
) : ViewModel() {
    fun getAllApplicants(): List<Applicant> {
        return repository.getAllApplicants()
    }
    fun deleteApplicant(id: Int) {
        repository.deleteApplicant(id)
    }
}