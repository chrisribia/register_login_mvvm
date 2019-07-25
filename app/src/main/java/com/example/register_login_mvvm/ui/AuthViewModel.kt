package com.example.register_login_mvvm.ui

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.register_login_mvvm.repositories.UserRepository
import com.example.register_login_mvvm.utils.ApiException
import com.example.register_login_mvvm.utils.Couroutines
import com.example.register_login_mvvm.utils.NoInternetException

class AuthViewModel(
    val repository : UserRepository
) : ViewModel() {
    var  email : String? = null
    var password : String? = null
    var username: String? = null
    var cpassword: String? = null

    var authListener : AuthListener? = null


    fun getLoggedInUser() = repository.getUser()

    fun onLoginClickButton(view : View){
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
           authListener?.onFailure("please enter a valid email or password")
            return
        }
        Couroutines.main {
            try {

                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
    }

    fun onRegisterClickButton(view : View){
        authListener?.onStarted()
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
            Couroutines.main {
                try {
                    val authResponse = repository.userRegister(username!!,email!!,password!!)
                    authResponse?.user?.let {
                        authListener?.onSuccess(it)
                        repository.saveUser(it)
                        return@main
                    }
                    authListener?.onFailure(authResponse?.message!!)
                }
                catch (e: ApiException ){
                    authListener?.onFailure(e.message!!)
                }
                catch (e: NoInternetException){
                    authListener?.onFailure(e.message!!)
                }

                
            }

        }

    }


}