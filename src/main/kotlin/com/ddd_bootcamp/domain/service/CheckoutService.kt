package com.ddd_bootcamp.domain.service

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Order

class CheckoutService {
    fun checkoutCart(cart: Cart): Order {
        cart.checkout()

        val products = cart.items.flatMap { item ->
            generateSequence { item.product }.take(item.quantity).toList()
        }
        return Order(products)
    }
}