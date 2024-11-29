package com.littlelemon.stocklookup.model

data class Stock(
    val prices: List<Price>
)

data class Price(
    val date: Long,
    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,
    val volume: Int,
    val adjclose: Double
)
