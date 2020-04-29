package com.devmmurray.mvvmbasics.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devmmurray.mvvmbasics.R
import com.devmmurray.mvvmbasics.data.Quote
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    private lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
        initializeUi()
    }

    private fun initializeUi() {
        viewModel.getQuotes().observe(this, Observer { quotesList ->
            val sb = StringBuilder()
            quotesList.forEach { quote ->
                sb.append("$quote\n\n")
                textView_quotes.text = sb.toString()
            }
        })
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
