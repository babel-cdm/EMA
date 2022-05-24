package es.babel.easymvvm.core.extension

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 */

import es.babel.easymvvm.core.constants.*
import java.util.Collections.emptyList

fun Int?.checkNull(defaultValue: Int = INT_ZERO): Int =  this ?: defaultValue
fun Float?.checkNull(defaultValue: Float = FLOAT_ZERO): Float = this ?: defaultValue
fun Short?.checkNull(defaultValue: Short = SHORT_ZERO): Short =  this ?: defaultValue
fun Long?.checNull(defaultValue: Long = LONG_ZERO): Long =  this ?: defaultValue
fun Double?.checkNull(defaultValue: Double = DOUBLE_ZERO): Double = this ?: defaultValue
fun Boolean?.checkNull(defaultValue: Boolean = false): Boolean =  this ?: defaultValue
fun <T> List<T>?.checkNull(defaultValue: List<T> = emptyList()): List<T> =  this ?: defaultValue
