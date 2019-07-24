package com.example.register_login_mvvm.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.register_login_mvvm.R
import com.example.register_login_mvvm.data.entities.User
import com.example.register_login_mvvm.databinding.ActivityLoginBinding
import com.example.register_login_mvvm.utils.hide
import com.example.register_login_mvvm.utils.show
import com.example.register_login_mvvm.utils.snackbar
import com.example.register_login_mvvm.utils.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),AuthListener, KodeinAware {

    override val kodein by kodein()

    private val factory: AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel :: class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this

    }
    override fun onStarted() {
    progress_bar.show()
        toast("welcome")
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()

    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)


    }
}
