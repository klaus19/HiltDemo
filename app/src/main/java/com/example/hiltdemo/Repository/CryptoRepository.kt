package com.example.hiltdemo.Repository

import com.example.hiltdemo.data.Crypto

interface CryptoRepository {

    fun getCrypto():List<Crypto>
}