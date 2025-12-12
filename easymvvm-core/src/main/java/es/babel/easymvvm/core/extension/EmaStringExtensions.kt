package es.babel.easymvvm.core.extension

import es.babel.easymvvm.core.constants.STRING_EMPTY

/**
 * Created by Carlos Mateo Benito on 2019-11-24.
 *
 * <p>
 * Copyright (c) 2019 by Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 */

fun String?.checkNull(defaultValue: String = STRING_EMPTY): String = this ?: defaultValue

fun String.getFormattedString(vararg data: Any?): String = String.format(this, *data)
