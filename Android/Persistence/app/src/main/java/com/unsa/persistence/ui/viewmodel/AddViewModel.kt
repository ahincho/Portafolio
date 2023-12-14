package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.domain.AddApplicantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor (
    private val addApplicantUseCase: AddApplicantUseCase
) : ViewModel() {
    fun addApplicant(applicant: Applicant) {
        addApplicantUseCase.invoke(applicant)
    }
}