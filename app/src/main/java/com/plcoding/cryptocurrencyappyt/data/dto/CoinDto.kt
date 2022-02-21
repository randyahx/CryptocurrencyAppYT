package com.plcoding.cryptocurrencyappyt.data.dto

import androidx.compose.foundation.isSystemInDarkTheme
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

// Contains ALL data returned from API
// Will be processed before passing to domain layer

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id=id,
        is_active = is_active,
        name=name,
        rank=rank,
        symbol=symbol
    )
}