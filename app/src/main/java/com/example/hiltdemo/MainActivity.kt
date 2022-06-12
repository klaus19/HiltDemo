package com.example.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.model.CryptoViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

private lateinit var cyptoList:RecyclerView

// viewModels() delegate used to get
// by view models will automatically construct the viewmodels using Hilt

private val viewmodel:CryptoViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cyptoList = findViewById(R.id.cryptocurrency_list)
        cyptoList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()
    }

    // Observing the live data
    private fun observeCryptoCurrency() {
        viewmodel.crypto.observe(this) {
              cyptoList.adapter = CryptoAdapter(it)
        }
    }
}