package com.ddd_bootcamp.domain.service

import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.ProductName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CompetitorPricingTest {

    @Test
    fun `get discounted price`(){
        val applePencil = ProductName("Apple Pencil")
        val competitorPricing = CompetitorPricing(mapOf(
            applePencil to Price(BigDecimal(150))
        ))
        val productPrice = competitorPricing.getProductPrice(applePencil)
        assertEquals(Price(BigDecimal(135)), productPrice)
    }
}