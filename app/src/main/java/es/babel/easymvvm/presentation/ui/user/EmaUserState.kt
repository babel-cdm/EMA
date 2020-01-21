package es.babel.easymvvm.presentation.ui.user

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
data class EmaUserState(val name:String = STRING_EMPTY,
                        val surname:String= STRING_EMPTY,
                        val itemList:List<EmaUserItemModel> = listOf()) : EmaBaseState