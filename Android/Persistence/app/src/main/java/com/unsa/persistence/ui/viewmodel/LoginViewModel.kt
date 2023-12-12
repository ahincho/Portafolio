package com.unsa.persistence.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.unsa.persistence.data.model.User
import com.unsa.persistence.data.providers.UserProvider

class LoginViewModel : ViewModel() {
    fun login(user: User): Boolean {
        return UserProvider.login(user)
    }
}