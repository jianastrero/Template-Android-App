package com.jianastrero.templateandroidapp.type.screen

import android.os.Bundle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlin.reflect.KClass

interface NavKeyType<T : Any> {
    val key: String
    val type: KClass<T>
}

fun NavKeyType<*>.toNavArgument() = navArgument(key) {
    type = when (this@toNavArgument.type) {
        Boolean::class -> NavType.BoolType
        Int::class -> NavType.IntType
        Long::class -> NavType.LongType
        Float::class -> NavType.FloatType
        Array<Boolean>::class -> NavType.BoolArrayType
        Array<Int>::class -> NavType.IntArrayType
        Array<Long>::class -> NavType.LongArrayType
        Array<Float>::class -> NavType.FloatArrayType
        Array<String>::class -> NavType.StringArrayType
        else -> NavType.StringType
    }
}

fun NavKeyType<*>.fromNavArgument(navArguments: Bundle): Any {
    return when (type) {
        Boolean::class -> navArguments.getBoolean(key)
        Int::class -> navArguments.getInt(key)
        Long::class -> navArguments.getLong(key)
        Float::class -> navArguments.getFloat(key)
        Array<Boolean>::class -> navArguments.getBooleanArray(key)
        Array<Int>::class -> navArguments.getIntArray(key)
        Array<Long>::class -> navArguments.getLongArray(key)
        Array<Float>::class -> navArguments.getFloat(key)
        Array<String>::class -> navArguments.getStringArray(key)
        else -> navArguments.getString(key, "")
    } as Any
}
