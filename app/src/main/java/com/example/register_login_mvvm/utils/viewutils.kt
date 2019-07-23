package com.example.register_login_mvvm.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}