package com.ddd_bootcamp.domain.events

import com.ddd_bootcamp.domain.CartItem
import com.ddd_bootcamp.domain.Product

sealed class Event
data class ItemAddedEvent(val item: CartItem) : Event()
data class ItemRemovedEvent(val product: Product) : Event()