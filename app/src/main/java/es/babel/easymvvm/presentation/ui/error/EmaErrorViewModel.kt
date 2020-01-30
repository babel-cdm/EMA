package es.babel.easymvvm.presentation.ui.error

import es.babel.easymvvm.android.viewmodel.EmaBaseViewModel
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.state.EmaState
import es.babel.easymvvm.presentation.base.BaseViewModel


class EmaErrorViewModel : BaseViewModel<EmaErrorState, EmaErrorNavigator.Navigation>() {

    lateinit var toolbarViewModel: EmaErrorToolbarViewModel

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override val initialViewState: EmaErrorState = EmaErrorState()

    fun onActionToolbar() {
        updateToNormalState { copy(showToolbarViewVisibility = false) }
        toolbarViewModel.showToolbar()
    }

    fun onToolbarUpdated(toolbarState: EmaState<EmaErrorToolbarState>) {
        when (toolbarState) {
            is EmaState.Normal -> {
                updateToNormalState {
                    copy(showToolbarViewVisibility = !toolbarState.data.visibility)
                }
            }
            is EmaState.Alternative -> { /* HANDLE LOADING STATE*/
            }
            is EmaState.Error -> { /*HANDLE ERROR STATE*/
            }
        }
    }

    fun onActionAddUser() {
        navigate(EmaErrorNavigator.Navigation.BackUser)
    }
}