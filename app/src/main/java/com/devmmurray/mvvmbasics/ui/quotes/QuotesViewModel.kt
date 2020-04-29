package com.devmmurray.mvvmbasics.ui.quotes

import androidx.lifecycle.ViewModel
import com.devmmurray.mvvmbasics.data.Quote
import com.devmmurray.mvvmbasics.data.QuotesRepository

class QuotesViewModel(private val quotesRepo: QuotesRepository): ViewModel() {

    fun getQuotes() = quotesRepo.getQuotes()
    fun addQuote(quote: Quote) = quotesRepo.addQuote(quote)


}