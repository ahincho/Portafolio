package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unsa.persistence.data.model.User
import com.unsa.persistence.data.providers.UserProvider

class LoginViewModel : ViewModel() {
    private val isLoading = MutableLiveData<Boolean>(true)
    fun login(user: User): Boolean {
        return UserProvider.login(user)
    }
}