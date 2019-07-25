package com.example.mvvm.data.ui

import android.app.Application
import com.example.mvvm.data.ui.data.network.NetworkConnectionInterceptor
import com.example.register_login_mvvm.data.entities.AppDatabase
import com.example.register_login_mvvm.data.network.MyApi
import com.example.register_login_mvvm.fragments.profile.ProfileViewModelFactory
import com.example.register_login_mvvm.quotes.QuotesViewModelFactory
import com.example.register_login_mvvm.repositories.QuotesRepository
import com.example.register_login_mvvm.repositories.UserRepository
import com.example.register_login_mvvm.ui.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMAplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMAplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from singleton { QuotesRepository(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }

}