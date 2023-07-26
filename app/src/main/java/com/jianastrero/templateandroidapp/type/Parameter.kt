package com.jianastrero.templateandroidapp.type

import kotlin.reflect.KClass

data class Parameter<T : Any>(val key: String, val type: KClass<T>)

inline fun <reified T : Any> parameter(key: String): Parameter<T> = Parameter(key, T::class)
