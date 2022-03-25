package com.example.currencytestcft.screens.currencyList


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytestcft.R
import com.example.currencytestcft.data.room.CurrencyEntity

class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val currencyName: TextView = itemView.findViewById(R.id.currencyName)
    private val currencyNominal: TextView = itemView.findViewById(R.id.currencyNominal)
    private val currencyCharCode: TextView = itemView.findViewById(R.id.currencyСharCode)
    private val currencyValue: TextView = itemView.findViewById(R.id.currencyValue)


    fun onBind(currency: CurrencyEntity, oneClickListener: CurrencyAdapter.OnItemClickListener) {
        currencyName.text = currency.name
        currencyNominal.text = currency.nominal.toString()
        currencyCharCode.text = currency.charCode
        currencyValue.text =  "${ currency.value }"

                itemView.setOnClickListener {
                    oneClickListener.onItemClick(currency)
                }
    }
}