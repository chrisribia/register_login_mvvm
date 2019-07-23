package com.example.register_login_mvvm.ui

interface AuthListener {
    fun onStarted(message: String)
    fun onSuccess(message : String)
    fun onFailure(message : String)

}