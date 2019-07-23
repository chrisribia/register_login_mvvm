package com.example.register_login_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.register_login_mvvm.R
import com.example.register_login_mvvm.databinding.ActivityLoginBinding
import com.example.register_login_mvvm.utils.toast

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
    }


    override fun onStarted(message: String ) {toast(message)
     }

    override fun onSuccess(message : String) {
        toast(message)
      }

    override fun onFailure(message : String)
    {
        toast(message)
          }

}
