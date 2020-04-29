package com.devmmurray.mvvmbasics.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devmmurray.mvvmbasics.data.QuotesRepository
import com.devmmurray.mvvmbasics.ui.quotes.QuotesViewModel


class QuotesViewModelFactory(private val repo: QuotesRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(repo) as T
    }
}