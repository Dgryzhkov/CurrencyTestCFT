package com.example.currencytestcft.dto

import com.squareup.moshi.Json
import java.io.Serializable

data class CurrencyMap (@field:Json(name = "Valute") val map: Map<String, Currency>)

data class Currency (@field:Json(name = "ID") val id: String,
                     @field:Json(name = "NumCode") val numCode: String,
                     @field:Json(name = "CharCode") val charCode: String,
                     @field:Json(name = "Nominal") val nominal: Int,
                     @field:Json(name = "Name") val name: String,
                     @field:Json(name = "Value") val value: Float,
                     @field:Json(name = "Previous") val previosValue: Float) : Serializable
