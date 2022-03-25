package com.example.currencytestcft.screens.currencyExchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.currencytestcft.R
import com.example.currencytestcft.data.room.CurrencyEntity


class CurrencyExchangeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_exchange, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currency = arguments?.get(CURRENCY_KEY) as CurrencyEntity

        val currencyNominal = view.findViewById<TextView>(R.id.currencyNominalExchange)
        val currencyValueInRub = view.findViewById<EditText>(R.id.currencyValueExchange)
        val currencyValue = view.findViewById<TextView>(R.id.currencyExchangeResult)

        var valueIRub = currencyValueInRub.text.toString().toFloat()

        currencyValueInRub.doOnTextChanged { text,_,_,_ ->
            if (!text.isNullOrEmpty()) {
                currencyValue.text = "${(text.toString().toFloat() / currency.value*currency.nominal)} ${currency.charCode} "
            }
        }

        currencyNominal.text = "${currency.nominal} ${currency.charCode} = ${currency.value} RUB"
        currencyValue.text = "${valueIRub} ${currency.charCode}"
    }

    companion object {
        private const val CURRENCY_KEY = "CURRENCY_KEY"

        fun newInstance(currency: CurrencyEntity?) = CurrencyExchangeFragment().apply{
            arguments = Bundle().apply {
                putSerializable(CURRENCY_KEY, currency)
            }
        }
    }
}

