package com.example.currencytestcft.data.api

import com.example.currencytestcft.dto.CurrencyMap
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("daily_json.js")
    fun getCurrencyList () : Call<CurrencyMap>
}