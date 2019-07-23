package com.example.register_login_mvvm.ui

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.register_login_mvvm.R
import com.example.register_login_mvvm.databinding.ActivityLoginBinding
import com.example.register_login_mvvm.databinding.ActivityRegisterBinding
import com.example.register_login_mvvm.utils.toast

class RegisterActivity : AppCompatActivity(),AuthListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityRegisterBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted(message: String) {
        toast(message)
      }

    override fun onSuccess(message: String) {
        toast(message)
      }

    override fun onFailure(message: String) {
        toast(message)
     }
}
