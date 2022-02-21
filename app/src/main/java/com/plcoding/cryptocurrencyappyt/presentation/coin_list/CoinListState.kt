package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.plcoding.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val is_loading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)