package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.ProductName

fun main() {
    val cart = Cart()
    val product = Product(ProductName("Apple Pencil"))
    cart.add(product)
    println("Cart = $cart")
}