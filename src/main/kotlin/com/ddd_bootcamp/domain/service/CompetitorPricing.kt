package com.ddd_bootcamp.domain.service

import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.ProductName

// DDD - doamin service
class CompetitorPricing(
    private val productPrices: Map<ProductName, Price> = mapOf(),
    private val discount: Long = 10
) {
    fun getProductPrice(product: ProductName): Price {
        val price = productPrices[product] ?: throw RuntimeException("product not found")
        return price.copy(value = price.reduceByPercent(discount))
    }
}