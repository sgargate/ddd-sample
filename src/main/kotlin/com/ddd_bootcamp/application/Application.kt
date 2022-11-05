package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product

fun main() {
    val cart = Cart()
    val product = Product("Apple Pencil")
    cart.add(product)
    println("Cart = $cart")
}