package es.babel.easymvvm.presentation.ui.backdata.creation

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-07
 */

data class EmaBackUserCreationState (
        val name:String = STRING_EMPTY,
        val surname:String = STRING_EMPTY
) : EmaBaseState