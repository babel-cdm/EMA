package es.babel.easymvvm.presentation.ui.error

import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseViewModel
import es.babel.easymvvm.presentation.ui.backdata.userlist.EmaBackUserViewModel

/**
 *
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

@Suppress("MemberVisibilityCanBePrivate")
class EmaErrorToolbarViewModel : BaseViewModel<EmaErrorToolbarState, EmaErrorNavigator.Navigation>() {

    override val initialViewState: EmaErrorToolbarState = EmaErrorToolbarState()

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun onResultListenerSetup() {
        addOnResultReceived(EmaBackUserViewModel.RESULT_USER_NUMBER) {
            notifySingleEvent(EmaExtraData(extraData = it.data as Int))
        }
    }

    fun onActionMenuHideToolbar() {
        hideToolbar()
    }

    fun showToolbar() {
        updateToNormalState {
            copy(visibility = true)
        }
    }

    fun hideToolbar() {
        updateToNormalState {
            copy(visibility = false)
        }
    }
}