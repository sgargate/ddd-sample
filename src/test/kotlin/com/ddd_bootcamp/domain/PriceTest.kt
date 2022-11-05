package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class PriceTest {
    @Test
    fun `prices should be compared as value object`(){
        val p1 = Price(BigDecimal.valueOf(10), Currency.getInstance("INR"))
        val p2 = Price(BigDecimal.valueOf(10), Currency.getInstance("INR"))
        assertEquals(p1, p2)
    }
}