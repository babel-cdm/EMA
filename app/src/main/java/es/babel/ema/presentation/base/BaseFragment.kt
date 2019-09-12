package es.babel.ema.presentation.base

import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.ema.presentation.injection.fragmentInjection
import org.kodein.di.Kodein

/**
 * TODO: Add a class header comment.
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseFragment<S : EmaBaseState, VM : EmaViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S,VM,NS>() {

    override val fragmentViewModelScope: Boolean = true

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module?  = fragmentInjection(this)

    override fun onStateNormal(data: S) {
        onNormal(data)
    }

    override fun onStateLoading(data: EmaExtraData) {
        onLoading(data)
    }

    override fun onSingleEvent(data: EmaExtraData) {
        onSingle(data)
    }

    override fun onStateError(error: Throwable) {
        onError(error)
    }

    abstract fun onNormal(data: S)

    abstract fun onLoading(data: EmaExtraData)

    abstract fun onSingle(data: EmaExtraData)

    abstract fun onError(error: Throwable)

}