package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list")
    object CoinDetailScreen: Screen("coin_detail")
}