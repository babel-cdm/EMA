package es.babel.ema.presentation.dialog.simple

import android.graphics.drawable.Drawable
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

data class SimpleDialogData(
        val title: String = "",
        val message: String = "",
        val accept: String = "",
        val cancel: String = "",
        val showCross: Boolean = true,
        val image: Drawable? = null,
        override val proportionWidth: Float? = 7/10f,
        override val proportionHeight: Float? = null) : EmaDialogData