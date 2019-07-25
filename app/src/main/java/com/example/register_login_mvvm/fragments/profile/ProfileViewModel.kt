package com.example.register_login_mvvm.fragments.profile

import androidx.lifecycle.ViewModel;
import com.example.register_login_mvvm.repositories.UserRepository

class ProfileViewModel(
    private val repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}
