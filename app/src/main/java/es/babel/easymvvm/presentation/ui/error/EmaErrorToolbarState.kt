package es.babel.easymvvm.presentation.ui.error

import es.babel.easymvvm.core.state.EmaBaseState

/**
 * State for error toolbar
 *
*
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

data class EmaErrorToolbarState(
        val visibility:Boolean = true
) : EmaBaseState