package com.jianastrero.templateandroidapp.enumeration

import com.jianastrero.templateandroidapp.type.Argument
import com.jianastrero.templateandroidapp.type.Parameter
import com.jianastrero.templateandroidapp.type.argument
import java.net.URLEncoder
import java.nio.charset.Charset

sealed class Screen(route: String) {

    private val _route = route

    open val arguments: List<Argument<*>> = emptyList()
    open val parameters: List<Parameter<*>> = emptyList()

    val route: String
        get() {
            var completeRoute = _route

            if (arguments.isNotEmpty()) {
                completeRoute += "/${arguments.joinToString("/") { "{${it.key}}" }}"
            }

            if (parameters.isNotEmpty()) {
                completeRoute += "?${parameters.joinToString("&") { "${it.key}={${it.key}}" }}"
            }

            return completeRoute
        }

    fun getRoute(
        arguments: Map<Argument<*>, Any> = emptyMap(),
        parameters: Map<Parameter<*>, Any> = emptyMap()
    ): String {
        var navRoute = _route

        if (arguments.entries.size != this.arguments.size || arguments.keys != this.arguments.map { it.key }) {
            throw Exception("Arguments size mismatch")
        }

        val unknownParameters = parameters.keys.filterNot { it in this.parameters }
        if (unknownParameters.isNotEmpty()) {
            throw Exception("Unknown parameters: ${unknownParameters.joinToString(", ")}")
        }

        if (this.arguments.isNotEmpty()) {
            navRoute += "/"

            this.arguments.forEachIndexed { index, argument ->
                navRoute += URLEncoder.encode(arguments[argument].toString(), Charset.defaultCharset().name())

                if (index != this.arguments.size - 1) {
                    navRoute += "/"
                }
            }
        }

        if (parameters.isNotEmpty()) {
            navRoute += "?${parameters.entries.joinToString("&") {
                "${it.key}=${URLEncoder.encode(it.value.toString(), Charset.defaultCharset().name())}"
            }}"
        }

        return navRoute
    }

    object Home : Screen("home")

    object Detail : Screen("route") {
        val TITLE = argument<String>("title")
        val VALUE = argument<Float>("value")

        override val arguments: List<Argument<*>> = listOf(TITLE, VALUE)
    }
}
