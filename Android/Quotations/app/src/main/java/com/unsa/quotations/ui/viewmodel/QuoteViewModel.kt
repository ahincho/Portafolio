package com.unsa.quotations.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unsa.quotations.data.model.QuoteModel
import com.unsa.quotations.data.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote() {
        val currentQuote = QuoteProvider.randomQuote()
        quoteModel.postValue(currentQuote)
    }
}