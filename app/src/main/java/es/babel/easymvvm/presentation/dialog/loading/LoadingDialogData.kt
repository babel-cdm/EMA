package es.babel.easymvvm.presentation.dialog.loading

import es.babel.easymvvm.core.dialog.EmaDialogData

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

data class LoadingDialogData(
        val title: String = "",
        val message: String = "",
        override val proportionWidth: Float? = 7/10f,
        override val proportionHeight: Float? = null) : EmaDialogData