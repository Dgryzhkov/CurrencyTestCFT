package com.example.currencytestcft.data.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencyentity")
    fun getAll() : LiveData<List<CurrencyEntity>>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(currencies: List<CurrencyEntity>)
}


@Database(entities = [CurrencyEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun currencyDao(): CurrencyDao
}