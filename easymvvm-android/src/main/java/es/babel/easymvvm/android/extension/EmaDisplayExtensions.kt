package es.babel.easymvvm.android.extension

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

/**
 * Extension methods for display feature
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

/**
 * Convert pixel integer to dp
 */
fun Int.toDp(context: Context):Int {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, toFloat(), context.resources.displayMetrics).roundToInt()
}