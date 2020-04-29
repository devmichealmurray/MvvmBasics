package com.devmmurray.mvvmbasics.util

import com.devmmurray.mvvmbasics.data.FakeDatabase
import com.devmmurray.mvvmbasics.data.QuotesRepository
import com.devmmurray.mvvmbasics.ui.base.QuotesViewModelFactory

object InjectorUtils {

    fun providesQuotesViewModelFactory(): QuotesViewModelFactory {
        val quotesRepository
                = QuotesRepository
            .getInstance(FakeDatabase.getInstance()
                .quoteDAO)
        return QuotesViewModelFactory(quotesRepository)
    }
}