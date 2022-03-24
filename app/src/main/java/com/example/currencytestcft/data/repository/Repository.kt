package com.example.currencytestcft.data.repository

import android.util.Log
import com.example.currencytestcft.data.api.ApiService
import com.example.currencytestcft.data.room.CurrencyDao
import com.example.currencytestcft.data.room.CurrencyMapper
import com.example.currencytestcft.dto.CurrencyMap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val service: ApiService, val currencyDao: CurrencyDao) {

    fun callCurrencyList() {
        service.getCurrencyList()
            .enqueue(object : Callback<CurrencyMap> {
                override fun onResponse(
                    call: Call<CurrencyMap>,
                    response: Response<CurrencyMap>
                ) {
                    response.body().let {
//                        liveData.value = it
                        it?.let { currencyMap ->
                            val currencyEntityList =
                                CurrencyMapper.mapFromCurrencyListToCurrencyEntityList(currencyMap.map.values.toList())
                            currencyDao.insertAll(currencyEntityList)
                            Log.d("retrofit", currencyEntityList.toString())
                        }
//                        Log.d("retrofit", currencyEntityList.toString())
                    }
                }

                override fun onFailure(call: Call<CurrencyMap>, t: Throwable) {
                    Log.d("retrofit", "call failed")
                }
            })
    }
}