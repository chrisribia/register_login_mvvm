package com.example.register_login_mvvm.ui

import com.example.register_login_mvvm.data.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user : User)
    fun onFailure(message : String)

}