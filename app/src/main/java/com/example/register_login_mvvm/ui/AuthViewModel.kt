package com.example.register_login_mvvm.ui

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var  email : String? = null
    var password : String? = null
    var username: String? = null
    var cpassword: String? = null

    var authListener : AuthListener? = null

    fun onLoginClickButton(view : View){
        authListener?.onStarted("started")
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
           authListener?.onFailure("please enter a valid email or password")
            return
        }
        authListener?.onSuccess("welcome home")
    }

    fun onRegisterClickButton(view : View){
        authListener?.onStarted("register started")
        if (email.isNullOrEmpty()){
            authListener?.onFailure("please enter email address")
            return
        }

        if (username.isNullOrEmpty()){
            authListener?.onFailure("please enter username")
            return
        }
        if (password.isNullOrEmpty()){
            authListener?.onFailure("enter password")
            return
        }
        if (password != cpassword){
            authListener?.onFailure("password doesn'match")
            return
        }

        authListener?.onSuccess("register successful")
    }

    fun regLink(view: View){
        Intent(view.context,RegisterActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}