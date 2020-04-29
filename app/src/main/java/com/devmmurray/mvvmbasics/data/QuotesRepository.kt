package com.devmmurray.mvvmbasics.data

class QuotesRepository private constructor(private val quoteDao: FakeQuoteDAO) {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile
        private var instance: QuotesRepository? = null

        fun getInstance(quoteDao: FakeQuoteDAO) =
            instance ?: synchronized(this) {
                instance ?: QuotesRepository(quoteDao).also { instance = it }
            }
    }

}