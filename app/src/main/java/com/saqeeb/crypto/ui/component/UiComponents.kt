package com.saqeeb.crypto.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
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
import java.util.Random
class CoinProvider : PreviewParameterProvider<CryptoCoin> {
    override val values = listOf(CryptoCoin(
        "btc",true,true,"BitCoin",1,"BTC","coin"
    )).asSequence()
}
@Preview
@Composable
fun CoinListItem(@PreviewParameter(CoinProvider::class) coin: CryptoCoin){
    Card {
        Row (modifier = Modifier.height(80.dp)){
            Box(
                modifier = Modifier
                    .weight(0.2f)
            ) {
                ItemHeaderByName(name = coin.symbol)
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
fun ItemHeaderByName(name:String){
    val colorState = remember {
        val rnd = Random()
        mutableStateOf(
            android.graphics.Color.argb(
                255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256))
        )
    }

    Box(
        modifier = Modifier
            .size(80.dp)
            .padding(6.dp)
            .background(Color(color = colorState.value), shape = CircleShape)
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