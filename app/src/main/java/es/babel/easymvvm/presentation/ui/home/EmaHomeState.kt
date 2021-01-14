package es.babel.easymvvm.presentation.ui.home

import es.babel.easymvvm.core.constants.INT_ZERO
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */
data class EmaHomeState(
        val userName: String = STRING_EMPTY,
        val userPassword: String = STRING_EMPTY,
        val defaultTitle: Int = INT_ZERO,
        val showPassword: Boolean = false,
        val rememberUser: Boolean = false
) : EmaBaseState