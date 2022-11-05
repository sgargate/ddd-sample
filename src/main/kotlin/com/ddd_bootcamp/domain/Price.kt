package com.ddd_bootcamp.domain

import java.math.BigDecimal
import java.util.*

data class Price(val value: BigDecimal, val currency: Currency): ValueObject<Price> {
    override fun sameValueAs(other: Price) = equals(other)
}

