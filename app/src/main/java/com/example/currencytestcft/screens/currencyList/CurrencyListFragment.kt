package com.example.currencytestcft.screens.currencyList

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytestcft.R
import com.example.currencytestcft.data.api.Retrofit
import com.example.currencytestcft.data.repository.Repository
import com.example.currencytestcft.data.room.CurrencyEntity
import com.example.currencytestcft.data.room.RoomModule
import com.example.currencytestcft.screens.currencyExchange.CurrencyExchangeFragment


class CurrencyListFragment : Fragment() {

    private val adapter =
        CurrencyAdapter(oneClickListener = object : CurrencyAdapter.OnItemClickListener {
            override fun onItemClick(currency: CurrencyEntity) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.currencyContainer,
                        CurrencyExchangeFragment.newInstance(currency),
                        "CurrencyExchangeFragment"
                    )
                    .addToBackStack("CONVERT_FR")
                    .commit()
            }
        })

    private val model: CurrencyListViewModel by lazy {
        CurrencyListViewModel(
            Repository(
                Retrofit.provideApi(Retrofit.provideRetrofit()),
                RoomModule.appdataBase.currencyDao()
            ),
            RoomModule.appdataBase
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("JC", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("JC", "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("JC", "onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.d("JC", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("JC", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("JC", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("JC", "onStop")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val rclView = view.findViewById<RecyclerView>(R.id.recyclerView)



        rclView.addItemDecoration(
            DividerItemDecoration(
                rclView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        model.data.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
            Log.d("yui", it.toString())
        })

        rclView?.layoutManager = LinearLayoutManager(requireContext())
        rclView?.adapter = adapter


    }

    companion object {
        fun newInstance() = CurrencyListFragment()
    }
}