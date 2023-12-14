package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.domain.DeleteApplicantUseCase
import com.unsa.persistence.domain.GetApplicantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (
    private val getApplicantsUseCase: GetApplicantsUseCase,
    private val deleteApplicantUseCase: DeleteApplicantUseCase
) : ViewModel() {
    fun getAllApplicants(): List<Applicant> {
        return getApplicantsUseCase.invoke()
    }
    fun deleteApplicant(id: Int) {
        deleteApplicantUseCase.invoke(id)
    }
}