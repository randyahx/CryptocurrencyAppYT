package com.plcoding.cryptocurrencyappyt.data.repositoryImpl

import com.plcoding.cryptocurrencyappyt.data.api.CoinApi
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}