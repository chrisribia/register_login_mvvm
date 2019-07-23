package com.example.register_login_mvvm.ui

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var  email : String? = null
    var password : String? = null

    var authListener : AuthListener? = null

    fun onLoginClickButton(view : View){
        authListener?.onStarted("started")
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
           authListener?.onFailure("please enter a valid email or password")
            return
        }
        authListener?.onSuccess("welcome home")
    }
}