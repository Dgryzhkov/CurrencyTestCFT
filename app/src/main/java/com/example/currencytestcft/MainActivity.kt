package com.example.currencytestcft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencytestcft.data.room.RoomModule
import com.example.currencytestcft.screens.currencyList.CurrencyListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomModule.init(this)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.currencyContainer, CurrencyListFragment.newInstance())
                .commit()
        }
    }
}