package com.example.register_login_mvvm.quotes

import androidx.lifecycle.ViewModel;
import com.example.register_login_mvvm.repositories.QuotesRepository
import com.example.register_login_mvvm.utils.lazyDeferred

class QuotesViewModel(
    repository : QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
