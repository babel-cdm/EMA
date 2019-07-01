package es.babel.ema.presentation.ui.emaway.user

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

class EmaUserViewModel : EmaViewModel<EmaUserState, EmaNavigationState>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }


    override fun createInitialViewState(): EmaUserState {
       return EmaUserState()
    }
}
