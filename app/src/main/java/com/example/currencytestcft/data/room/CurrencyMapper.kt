package com.example.currencytestcft.data.room

import com.example.currencytestcft.dto.Currency

object CurrencyMapper {
    fun mapFromCurrencyToCurrencyEntity(currency: Currency): CurrencyEntity {
        return CurrencyEntity(
            currency.id, currency.numCode, currency.charCode,
            currency.nominal, currency.name, currency.value, currency.previosValue
        )
    }

    fun mapFromCurrencyListToCurrencyEntityList(currencyList: List<Currency>): List<CurrencyEntity> {
        val currencyEntityList = mutableListOf<CurrencyEntity>()
        for (currency in currencyList) {
            currencyEntityList.add(mapFromCurrencyToCurrencyEntity(currency))
        }
        return currencyEntityList
    }

}