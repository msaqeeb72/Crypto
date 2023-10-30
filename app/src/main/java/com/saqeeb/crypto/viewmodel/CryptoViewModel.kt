package com.saqeeb.crypto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.model.GlobalDataModel
import com.saqeeb.crypto.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(private val repository: CryptoRepository):ViewModel() {
    val allCoins:StateFlow<List<CryptoCoin>>
        get() = repository.allCoins

    val selectedCoin : StateFlow<CryptoCoin?>
        get() = repository.selectedCoin

    val globalData : StateFlow<GlobalDataModel?>
        get() = repository.globalData
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getGlobalData()
            repository.getAllCryptoCoins()
        }
    }
    fun getCoinById(coinId:String){
        viewModelScope.launch(Dispatchers.IO){
            repository.getCoinById(coinId)
        }
    }
}