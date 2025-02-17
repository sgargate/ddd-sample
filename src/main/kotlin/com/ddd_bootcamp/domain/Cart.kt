package com.ddd_bootcamp.domain

import com.ddd_bootcamp.domain.events.CardCheckedOut
import com.ddd_bootcamp.domain.events.Event
import com.ddd_bootcamp.domain.events.ItemAddedEvent
import com.ddd_bootcamp.domain.events.ItemRemovedEvent

class Cart(
    private val id: CartId = CartId.generate(),
    val items: MutableList<CartItem> = ArrayList(),
    private val events: MutableList<Event> = ArrayList(),
): Entity<Cart> {
    fun add(product: Product) {
        add(product, 1)
    }

    fun checkout() {
        apply(CardCheckedOut(this.items))
    }

    private fun apply(cardCheckedOut: CardCheckedOut) {
        events.add(cardCheckedOut)
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

    fun getRemovedProducts(): Set<Product> = events.filterIsInstance<ItemRemovedEvent>()
        .map { it.product }.toSet()

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

    override fun hasSameIdentityAs(other: Cart) = equals(other)

    override fun equals(other: Any?): Boolean {
        return if (this === other) true
        else if (other !is Cart) false
        else id == other.id
    }

    override fun hashCode() = id.hashCode()
}

data class CartItem(val product: Product, val quantity: Int)

data class CartId (val id: Int) {
    companion object {
        var id: Int = 0
        fun generate(): CartId {
            return CartId(id++)
        }
    }
}

data class Order(val products: List<Product>)