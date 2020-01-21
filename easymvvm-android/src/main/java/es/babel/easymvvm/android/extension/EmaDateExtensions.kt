package es.babel.easymvvm.android.extension

import es.babel.easymvvm.core.constants.LONG_ZERO
import es.babel.easymvvm.core.constants.STRING_EMPTY
import java.text.SimpleDateFormat
import java.util.*

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */

const val DATE_FORMAT_DDMMYYYY_HHMM = "dd/MM/yyyy HH:mm"
const val DATE_FORMAT_DDMMYYYY = "dd/MM/yyyy"
const val DATE_FORMAT_YYYYMMDD = "yyyy/MM/dd"
const val DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy"
const val DATE_FORMAT_HHMM = "HH:mm"

/**
 * Convert a string with provided format to timestamp
 * @param dateFormat Format of the string
 */
fun String.toTimeStamp(dateFormat: String): Long = try {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    val date = formatter.parse(this)
    date.time
} catch (e: Exception) {
    LONG_ZERO
}

/**
 * Convert a long timestamp to a string with provided format
 * @param dateFormat Format of the string
 */
fun Long.toDateFormat(dateFormat: String): String = try {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    val date = Date(this)
    formatter.format(date) ?: STRING_EMPTY
} catch (e: java.lang.Exception) {
    STRING_EMPTY
}