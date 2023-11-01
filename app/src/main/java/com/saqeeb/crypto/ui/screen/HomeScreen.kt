package com.saqeeb.crypto.ui.screen

import android.graphics.Color
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.ui.component.CoinListItem
import com.saqeeb.crypto.ui.component.GlobalDataHeader
import com.saqeeb.crypto.viewmodel.CryptoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel:CryptoViewModel = hiltViewModel()

    val loadingState = viewModel.isLoading.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Crypto", color = White)
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Black),
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                }
            }
            )
        }) {
        Box(modifier = Modifier.padding(it)){
            Surface {
                HomeScreeBody()
                if (loadingState.value)
                    Box (modifier = Modifier
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator()
                    }

            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreeBody(){
    val viewModel:CryptoViewModel = hiltViewModel()
    val coinsState = viewModel.allCoins.collectAsState()
    val globalDataState = viewModel.globalData.collectAsState()
    Column{
        LazyColumn(
            content = {
                item {
                    if(globalDataState.value!=null)
                        GlobalDataHeader(data = globalDataState.value!!)
                }
            items(coinsState.value){
                CoinListItem(coin = it)
            }
        })
    }
}