package com.ddd_bootcamp.domain

import java.math.BigDecimal
import java.util.*

data class Product(val name: String, val price: Price = Price(BigDecimal.ZERO, Currency.getInstance("INR")))