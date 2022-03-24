package com.example.currencytestcft.screens.currencyList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.currencytestcft.data.repository.Repository
import com.example.currencytestcft.data.room.AppDataBase
import com.example.currencytestcft.data.room.CurrencyEntity

class CurrencyListViewModel(repository: Repository, db: AppDataBase) : ViewModel() {

    var data: LiveData<List<CurrencyEntity>>

    init {
        data = db.currencyDao().getAll()
        repository.callCurrencyList()
    }
}