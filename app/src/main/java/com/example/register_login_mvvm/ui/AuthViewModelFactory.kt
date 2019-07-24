package com.example.register_login_mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.register_login_mvvm.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repository: UserRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}