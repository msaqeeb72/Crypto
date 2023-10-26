package com.saqeeb.crypto.api

import com.saqeeb.crypto.model.AllCoinsResponse
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.model.GlobalDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("global")
    suspend fun getGlobalData() : Response<GlobalDataModel>

    @GET("coins")
    suspend fun getAllCryptoCoins() : Response<AllCoinsResponse>

    @GET("coins/{coinId}")
    suspend fun getCryptoCoin(@Path("coinId") coinId:String) : Response<CryptoCoin>
}
