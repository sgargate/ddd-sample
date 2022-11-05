package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertTrue

internal class CartTest {
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val applePencil = Product("Apple Pencil")
        cart.add(applePencil)
        val headphone = Product("Sony wireless headphone")
        cart.add(headphone)


        assertEquals(2, cart.size())
        assertTrue(cart.contains(applePencil))
        assertTrue(cart.contains(headphone))
    }

    @Test
    fun shouldAddProductWithSpecifiedQuantity() {
        val cart = Cart()
        val applePencil = Product("Apple Pencil")
        cart.add(applePencil, 2)

        assertEquals(2, cart.productQuantity(applePencil))
        assertEquals(2, cart.size())
    }

    @Test
    fun `should be able to remove product from cart`(){
        val cart = Cart()
        val applePencil = Product("Apple Pencil")
        cart.add(applePencil, 2)
        cart.removeItem(applePencil)
        assertEquals(0, cart.size())
    }
}