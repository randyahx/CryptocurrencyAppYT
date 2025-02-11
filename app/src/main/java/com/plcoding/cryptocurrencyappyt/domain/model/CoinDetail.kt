package com.plcoding.cryptocurrencyappyt.domain.model;

import com.plcoding.cryptocurrencyappyt.data.dto.TeamMember;

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
