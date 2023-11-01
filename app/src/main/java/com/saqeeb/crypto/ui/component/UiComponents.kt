package com.saqeeb.crypto.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saqeeb.crypto.R
import com.saqeeb.crypto.model.CryptoCoin
import com.saqeeb.crypto.model.GlobalDataModel
import com.saqeeb.crypto.util.Utils
import com.saqeeb.crypto.util.toTextFormat
import java.util.Random
class CoinProvider : PreviewParameterProvider<CryptoCoin> {
    override val values = listOf(CryptoCoin(
        "btc",true,true,"BitCoin",1,"BTC","coin"
    )).asSequence()
}
@Composable
fun CoinListItem(@PreviewParameter(CoinProvider::class) coin: CryptoCoin){
    Card (
        modifier = Modifier
            .padding(6.dp)
    ){
        Row (
            modifier = Modifier
                .height(80.dp)
        ){
            Box(
                modifier = Modifier
                    .weight(0.2f)
            ) {
                val colorState = remember {
                    mutableStateOf(
                        Utils.generateRandomColor()
                    )
                }
                ItemHeaderByName(name = coin.symbol, color = colorState.value)
            }
            Box(
                modifier = Modifier
                    .weight(0.6f)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                    ) {
                    Box (modifier = Modifier.height(25.dp)){
                        Row {
                            Text(
                                text = coin.name,
                                maxLines = 1,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            if(coin.is_new)
                                Image(
                                    painter = painterResource(id = R.drawable.new_image),
                                    contentDescription = "new",
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                        }


                    }
                    Box (modifier = Modifier.height(25.dp)){
                        Text(
                            text = coin.type,
                            maxLines = 1,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace
                        )

                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(0.2f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if(coin.is_active)"Active" else "In-Active",
                        maxLines = 1,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace,
                    )
                }

            }
        }
    }
}


@Composable
fun ItemHeaderByName(name:String,color: Color){


    Box(
        modifier = Modifier
            .size(80.dp)
            .padding(6.dp)
            .background(color, shape = CircleShape)
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            color = Color.White,
            fontSize = 25.sp,
            maxLines = 1
        )
    }
}

@Composable
fun GlobalDataHeader(data:GlobalDataModel){
    Row(Modifier.horizontalScroll(rememberScrollState())) {
        GlobalDataHeaderItem(
            title = "Market Cap",
            value = data.market_cap_usd.toTextFormat()
        )
        GlobalDataHeaderItem(
            title = "Volume",
            value = data.volume_24h_usd.toTextFormat()
        )
        GlobalDataHeaderItem(
            title = "BTC Dominance",
            value = data.bitcoin_dominance_percentage.toString(),
            symbol = "%"
        )
        GlobalDataHeaderItem(
            title = "Crypto Coins",
            value = data.cryptocurrencies_number.toString(),
            symbol = ""
        )

    }
}

@Composable
fun GlobalDataHeaderItem(title:String, value:String,symbol:String="$"){

    Card(modifier = Modifier
        .padding(4.dp)
        .height(70.dp)
        .width(120.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 15.sp,
                maxLines = 1
            )
            Divider()
            Text(
                text = "$value $symbol",
                color = Color.White,
                fontSize = 22.sp,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
            )
        }
    }

}
