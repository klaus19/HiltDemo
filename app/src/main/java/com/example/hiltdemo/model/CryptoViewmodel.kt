package com.example.hiltdemo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltdemo.Repository.CryptoRepository
import com.example.hiltdemo.data.Crypto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoViewmodel @Inject constructor(
        private val cryptoRepository: CryptoRepository
):ViewModel() {
    private val _cryptoEmitter = MutableLiveData<List<Crypto>>()
    val crypto:LiveData<List<Crypto>> = _cryptoEmitter

    init {
        loadCrypto()
    }

    private fun loadCrypto() {
        _cryptoEmitter.value=cryptoRepository.getCrypto()
    }
}