package es.babel.ema.presentation.dialog.loading

import es.babel.easymvvm.core.dialog.EmaDialogData

/**
 * TODO: Add a class header comment.
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

data class LoadingDialogData(
        val title: String = "",
        val message: String = "",
        override val proportionWidth: Float? = null,
        override val proportionHeight: Float? = null) : EmaDialogData