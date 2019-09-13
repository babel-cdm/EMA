package es.babel.ema.presentation.ui.error

import es.babel.easymvvm.core.state.EmaBaseState

/**
 * State for error toolbar
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

data class EmaToolbarState(
        val visibility:Boolean = true
) : EmaBaseState