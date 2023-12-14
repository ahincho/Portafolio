package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsa.persistence.data.model.User
import com.unsa.persistence.domain.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor (
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {
    fun insertUserInDatabase(user: User) {
        insertUserUseCase.invoke(user)
    }
}