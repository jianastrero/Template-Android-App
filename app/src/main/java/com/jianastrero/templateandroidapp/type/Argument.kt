package com.jianastrero.templateandroidapp.type

import kotlin.reflect.KClass

data class Argument<T : Any>(val key: String, val type: KClass<T>)

inline fun <reified T : Any> argument(key: String): Argument<T> = Argument(key, T::class)
