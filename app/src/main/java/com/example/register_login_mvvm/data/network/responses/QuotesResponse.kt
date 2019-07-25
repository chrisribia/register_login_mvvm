package com.example.register_login_mvvm.data.network.responses

import com.example.register_login_mvvm.data.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)