package com.saqeeb.crypto.ui.screen

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.ui.component.CoinListItem
import com.saqeeb.crypto.viewmodel.CryptoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel:CryptoViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Crypto", color = White)
            },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Black))
        }) {
        Box(modifier = Modifier.padding(it)){
            Column {
                CoinListItem(
                    CryptoCoin(
                    "btc",true,true,"BitCoin",1,"BTC","coin"
                )
                )
                CoinListItem(CryptoCoin(
                    "btc",true,true,"BitCoin",1,"BTC","coin"
                ))
                CoinListItem(CryptoCoin(
                    "btc",true,true,"BitCoin",1,"BTC","coin"
                ))
                CoinListItem(CryptoCoin(
                    "btc",true,true,"BitCoin",1,"BTC","coin"
                ))
            }
        }
    }
}