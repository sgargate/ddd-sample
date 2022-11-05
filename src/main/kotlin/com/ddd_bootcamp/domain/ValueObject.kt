package com.ddd_bootcamp.domain

interface ValueObject<T> {
    fun sameValueAs(other: T): Boolean
}