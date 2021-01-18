package es.babel.easymvvm.presentation.base

import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.injection.fragmentInjection
import org.kodein.di.Kodein

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

abstract class BaseFragment<S : EmaBaseState, VM : EmaViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S, VM, NS>() {

    override val fragmentViewModelScope: Boolean = true

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module?  = fragmentInjection(this)

    override fun onStateNormal(data: S) {
        onNormal(data)
    }

    override fun onStateNormalFirstTime(data: S) {
        onNormalFirstTime(data)
    }

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    override fun onSingleEvent(data: EmaExtraData) {
        onSingle(data)
    }

    override fun onStateError(error: Throwable) {
        onError(error)
    }

    abstract fun onNormal(data: S)

    abstract fun onNormalFirstTime(data: S)

    abstract fun onAlternative(data: EmaExtraData)

    abstract fun onSingle(data: EmaExtraData)

    abstract fun onError(error: Throwable)

}