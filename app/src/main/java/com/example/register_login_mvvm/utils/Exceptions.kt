package com.example.register_login_mvvm.utils

import java.io.IOException


class NoInternetException(message: String) : IOException(message)


class ApiException(message: String): IOException(message)