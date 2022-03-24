package com.example.currencytestcft.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofit {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.cbr-xml-daily.ru/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun provideApi(retrofit: Retrofit) : ApiService {
        return retrofit.create((ApiService::class.java))
    }
}