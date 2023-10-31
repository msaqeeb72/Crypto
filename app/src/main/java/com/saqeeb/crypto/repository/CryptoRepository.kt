package com.saqeeb.crypto.repository

import com.saqeeb.crypto.api.CryptoApi
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.model.GlobalDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class CryptoRepository @Inject constructor(private val cryptoApi: CryptoApi) {
    private val _allCoins = MutableStateFlow<List<CryptoCoin>>(emptyList())
    private val _selectedCoin = MutableStateFlow<CryptoCoin?>(null)
    private val _globalData = MutableStateFlow<GlobalDataModel?>(null)
    private val _isLoading = MutableStateFlow<Boolean>(false)

    val allCoins: StateFlow<List<CryptoCoin>>
        get() = _allCoins

    val selectedCoin : StateFlow<CryptoCoin?>
        get() = _selectedCoin

    val globalData : StateFlow<GlobalDataModel?>
        get() = _globalData
    val isLoading : StateFlow<Boolean>
        get() = _isLoading
    suspend fun getAllCryptoCoins() {
        _isLoading.emit(true)
        val response = cryptoApi.getAllCryptoCoins()
        _isLoading.emit(false)
        if(response.isSuccessful && response.code() == 200 && response.body()!=null){
            _allCoins.emit(response.body()!!)
        }
    }


    suspend fun getCoinById(coinId: String) {
        _isLoading.emit(true)
        val response = cryptoApi.getCryptoCoin(coinId)
        _isLoading.emit(false)
        if(response.isSuccessful && response.code() == 200 && response.body()!=null){
            _selectedCoin.emit(response.body())
        }
    }

    suspend fun getGlobalData() {
        _isLoading.emit(true)
        val response = cryptoApi.getGlobalData()
        _isLoading.emit(false)
        if(response.isSuccessful && response.code() == 200 && response.body()!=null){
            _globalData.emit(response.body())
        }
    }
}