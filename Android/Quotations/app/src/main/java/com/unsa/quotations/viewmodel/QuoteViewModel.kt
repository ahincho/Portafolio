package com.unsa.quotations.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unsa.quotations.model.QuoteModel
import com.unsa.quotations.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote() {
        val currentQuote = QuoteProvider.randomQuote()
        quoteModel.postValue(currentQuote)
    }
}