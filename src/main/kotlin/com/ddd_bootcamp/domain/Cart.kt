package com.ddd_bootcamp.domain

import java.util.ArrayList

data class Cart(
    private val items: MutableList<CartItem> = ArrayList()
) {
    fun add(product: Product) {
        add(product, 1)
    }

    fun add(product: Product, quantity: Int) {
        items.add(CartItem(product, quantity))
    }

    fun size() = items.sumOf { it.quantity }

    fun contains(product: Product) = items.any { it.product == product }

    fun productQuantity(product: Product) = items.find { it.product == product }?.quantity ?: 0

    fun removeItem(product: Product) {
        items.removeAll { it.product == product }
    }
}

data class CartItem(val product: Product, val quantity: Int)