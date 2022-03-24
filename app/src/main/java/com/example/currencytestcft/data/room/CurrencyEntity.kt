package com.example.currencytestcft.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class CurrencyEntity(
    val id: String,
    val numCode: String,
    val  charCode: String,
    val nominal: Int,
    @PrimaryKey
    val name: String,
    val value: Float,
    val previosValue: Float
): Serializable