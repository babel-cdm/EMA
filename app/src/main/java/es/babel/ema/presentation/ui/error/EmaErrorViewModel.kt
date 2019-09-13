package es.babel.ema.presentation.ui.error

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.state.EmaState
import es.babel.ema.presentation.ui.home.EmaHomeNavigator


class EmaErrorViewModel : EmaViewModel<EmaErrorState, EmaHomeNavigator.Navigation>() {

    lateinit var toolbarViewModel: EmaToolbarViewModel

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun createInitialViewState(): EmaErrorState = EmaErrorState()

    fun onActionToolbar() {
        updateViewState { copy(showToolbarViewVisibility = false) }
        toolbarViewModel.showToolbar()
    }

    fun onToolbarUpdated(toolbarState: EmaState<EmaToolbarState>) {
        when (toolbarState) {
            is EmaState.Normal -> {
                updateViewState {
                    copy(showToolbarViewVisibility = !toolbarState.data.visibility)
                }
            }
            is EmaState.Loading -> { /* HANDLE LOADING STATE*/
            }
            is EmaState.Error -> { /*HANDLE ERROR STATE*/
            }
        }
    }

}