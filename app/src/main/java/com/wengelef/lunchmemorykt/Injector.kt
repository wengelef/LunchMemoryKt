package com.wengelef.lunchmemorykt

interface Injector<T> {
    fun component(): T
}