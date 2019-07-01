package es.babel.ema.presentation.ui.emaway.user

import es.babel.easymvvm.core.state.EmaBaseState

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
data class EmaUserState(val name:String = "",
                        val surname:String="") : EmaBaseState