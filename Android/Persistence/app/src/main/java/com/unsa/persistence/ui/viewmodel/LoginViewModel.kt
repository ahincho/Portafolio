package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsa.persistence.data.model.User
import com.unsa.persistence.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    fun getSuccessfulLogin(user: User): Boolean {
        return loginUseCase.invoke(user)
    }
}