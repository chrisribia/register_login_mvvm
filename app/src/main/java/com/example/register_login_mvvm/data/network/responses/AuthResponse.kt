package com.example.register_login_mvvm.data.network.responses

import com.example.register_login_mvvm.data.entities.User

class AuthResponse (
    val isSuccessful : Boolean?,
    val message : String?,
    val user : User
)