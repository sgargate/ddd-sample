package com.ddd_bootcamp.domain

import kotlin.collections.ArrayList

data class Cart(
    private val events: MutableList<Event> = ArrayList(),
    private val items: MutableList<CartItem> = ArrayList(),
) {
    fun add(product: Product) {
        add(product, 1)
    }

    fun add(product: Product, quantity: Int) {
        apply(ItemAddedEvent(CartItem(product, quantity)))
    }

    fun size() = items.sumOf { it.quantity }

    fun contains(product: Product) = items.any { it.product == product }

    fun productQuantity(product: Product) = items.find { it.product == product }?.quantity ?: 0

    fun removeItem(product: Product) {
        apply(ItemRemovedEvent(product))

    }

    fun getRemovedProducts(): List<Product> = events.filterIsInstance<ItemRemovedEvent>().map { it.product }

    private fun apply(event: ItemAddedEvent) {
        events.add(event)
        items.add(event.item)
    }

    private fun apply(event: ItemRemovedEvent) {
        val removed = items.removeIf { it.product == event.product }
        if (removed) {
            events.add(event)
        }
    }
}

data class CartItem(val product: Product, val quantity: Int)

sealed class Event
data class ItemAddedEvent(val item: CartItem) : Event()
data class ItemRemovedEvent(val product: Product) : Event()
