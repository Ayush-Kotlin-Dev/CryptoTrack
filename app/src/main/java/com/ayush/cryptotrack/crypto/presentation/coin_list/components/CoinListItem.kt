package com.ayush.cryptotrack.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayush.cryptotrack.R
import com.ayush.cryptotrack.crypto.presentation.models.CoinUi
import com.ayush.cryptotrack.crypto.presentation.models.DisplayableNumber

@Composable
fun CoinListItem(
    coinUi: CoinUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()){
        Color.White
    } else {
        Color.Black
    }
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column (
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = coinUi.symbol,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(
                text = coinUi.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )

        }
        Column(
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = coinUi.priceUsd.formatted,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Text(
                text = coinUi.changePercent24Hr.formatted,
                fontSize = 14.sp,
                color = contentColor
            )
        }

    }
}


@Preview(showBackground = true)
@PreviewLightDark
@Composable
fun CoinListItemPreview() {
    val sampleCoinUi = CoinUi(
        id = "bitcoin",
        name = "Bitcoin",
        symbol = "BTC",
        rank = 1,
        marketCapUsd = DisplayableNumber(1_000_000.0, "$1M"),
        priceUsd = DisplayableNumber(50_000.0, "$50K"),
        changePercent24Hr = DisplayableNumber(0.0, "0%"),
        iconRes = R.drawable.btc
    )

    MaterialTheme {
        CoinListItem(
            coinUi = sampleCoinUi,
            onClick = {}
        )
    }
}