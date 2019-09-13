package es.babel.ema.presentation.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * TODO: Add a class header comment.
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseViewModel<S, NS : EmaNavigationState> : EmaViewModel<S, NS> ()