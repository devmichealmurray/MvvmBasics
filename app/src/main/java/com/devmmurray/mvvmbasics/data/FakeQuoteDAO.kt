package com.devmmurray.mvvmbasics.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDAO {
    private val quotesList = mutableListOf<Quote>()
    private val _quotes = MutableLiveData<List<Quote>>()

    init {
        _quotes.value = quotesList
    }

    fun addQuote(quote: Quote) {
        quotesList.add(quote)
        _quotes.value = quotesList
    }

    fun getQuotes() = _quotes as LiveData<List<Quote>>
}