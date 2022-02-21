package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecases.GetCoinsUseCase
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.net.CookieHandler
import javax.inject.Inject

// Maintain state
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An error has occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(is_loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}