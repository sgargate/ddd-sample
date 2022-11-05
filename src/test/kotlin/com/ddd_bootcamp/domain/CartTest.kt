package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class CartTest {
    private val applePencil = Product("Apple Pencil")
    private val headphone = Product("Sony wireless headphone")

    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        cart.add(applePencil)

        cart.add(headphone)

        assertEquals(2, cart.size())
        assertTrue(cart.contains(applePencil))
        assertTrue(cart.contains(headphone))
    }

    @Test
    fun shouldAddProductWithSpecifiedQuantity() {
        val cart = Cart()
        cart.add(applePencil, 2)

        assertEquals(2, cart.productQuantity(applePencil))
        assertEquals(2, cart.size())
    }

    @Test
    fun `should be able to remove product from cart`(){
        val cart = Cart()
        cart.add(applePencil, 2)
        cart.removeItem(applePencil)
        assertEquals(0, cart.size())
    }

    @Test
    fun `should get list of Products removed cart`(){
        val cart = Cart()
        cart.add(applePencil, 2)
        cart.removeItem(applePencil)
        assertContains(cart.getRemovedProducts(), applePencil)
    }

    @Test
    fun `should be able to differentiate carts`(){
        val cart1 = Cart()
        val cart2 = Cart()

        cart1.add(headphone)
        cart2.add(headphone)
        assertNotEquals(cart1, cart2)
    }
}