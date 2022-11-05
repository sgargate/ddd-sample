package com.ddd_bootcamp.domain.service

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.ProductName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckoutServiceTest {

    @Test
    fun checkout() {
        val cart = Cart()
        cart.add(Product(ProductName("Apple Pencil")), 2)
        val order = CheckoutService().checkoutCart(cart)
        assertEquals(2, order.products.size)
    }
}