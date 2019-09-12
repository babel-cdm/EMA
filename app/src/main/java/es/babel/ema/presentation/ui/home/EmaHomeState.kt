package es.babel.ema.presentation.ui.home

import es.babel.easymvvm.core.state.EmaBaseState

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
data class EmaHomeState(
        val userName: String = "",
        val userPassword: String = "",
        val showPassword: Boolean = false,
        val rememberUser: Boolean = false
) : EmaBaseState