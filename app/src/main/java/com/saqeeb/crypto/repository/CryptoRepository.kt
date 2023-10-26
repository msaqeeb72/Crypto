package com.saqeeb.crypto.repository

import com.saqeeb.crypto.api.CryptoApi
import javax.inject.Inject

class CryptoRepository @Inject constructor(private val cryptoApi: CryptoApi) {
    suspend fun fetch() {
        val response = cryptoApi.getAllCryptoCoins()
        var len = response.body()!!.size
    }
}