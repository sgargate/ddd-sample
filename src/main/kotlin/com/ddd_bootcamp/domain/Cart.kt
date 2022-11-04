package com.ddd_bootcamp.domain

data class Cart(val products: MutableList<Product> = ArrayList()) {
    fun add(product: Product) {
        products.add(product)
    }
}