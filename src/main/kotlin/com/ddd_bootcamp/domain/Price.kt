package com.ddd_bootcamp.domain

import java.math.BigDecimal
import java.util.*

data class Price(val value: BigDecimal, val currency: Currency = Currency.getInstance("INR")): ValueObject<Price> {
    override fun sameValueAs(other: Price) = equals(other)
    fun reduceByPercent(percent: Long): BigDecimal =
        value.minus(value.multiply(BigDecimal(percent).divide(BigDecimal(100)))).setScale(0)
}

