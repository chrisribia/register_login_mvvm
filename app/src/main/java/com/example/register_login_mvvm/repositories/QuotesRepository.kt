package com.example.register_login_mvvm.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.register_login_mvvm.data.entities.AppDatabase
import com.example.register_login_mvvm.data.entities.Quote
import com.example.register_login_mvvm.data.network.MyApi
import com.example.register_login_mvvm.data.network.SafeApiResponse
import com.example.register_login_mvvm.utils.Couroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesRepository (

    private val api : MyApi,

    private val db : AppDatabase

) : SafeApiResponse(){
    private val quotes = MutableLiveData<List<Quote>>()
    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    private suspend fun fetchQuotes(){
        if (isFetchNeeded()){
            val response = apiRequest { api.getQuotes()
            }
            quotes.postValue(response.quotes)
        }

    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }

    }
    private fun isFetchNeeded() : Boolean{
        return  true
    }
    private fun saveQuotes(quotes: List<Quote>){
        Couroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}