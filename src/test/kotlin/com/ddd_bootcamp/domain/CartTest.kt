package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CartTest {
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        cart.add(product)
        val actual = cart.getProducts()
        Assertions.assertEquals(1, actual.size)
        Assertions.assertEquals("Some test product", actual[0].name)
    }
}