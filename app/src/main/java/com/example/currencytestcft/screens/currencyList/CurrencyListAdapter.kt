package com.example.currencytestcft.screens.currencyList


import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytestcft.R
import com.example.currencytestcft.data.room.CurrencyEntity

class CurrencyAdapter(val oneClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CurrencyViewHolder>() {

    private val currencyList: MutableList<CurrencyEntity> = mutableListOf()

    fun setItems(newCurrencyList: List<CurrencyEntity>) {
        currencyList.clear()
        currencyList.addAll(newCurrencyList)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(currency: CurrencyEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.currency_view_holder, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.onBind(currencyList[position], oneClickListener)
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }
}