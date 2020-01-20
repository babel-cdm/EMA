package es.babel.easymvvm.presentation.ui.user

import es.babel.domain.manager.ResourceManager
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseViewModel
import es.babel.easymvvm.presentation.ui.home.EmaHomeToolbarViewModel

class EmaUserViewModel(private val resourceManager: ResourceManager) : BaseViewModel<EmaUserState, EmaNavigationState>() {

    var toolbarViewModel: EmaHomeToolbarViewModel? = null

    companion object {
        const val SINGLE_EVENT_GROUP = 0
        const val SINGLE_EVENT_USER = 1
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        val list = createListItems()
        updateToNormalState {
            copy(itemList = list)
        }
    }

    private fun createListItems(): List<EmaUserItemModel> {
        return listOf(
                EmaUserRightModel(3),
                EmaUserLeftModel("Carmabs"),
                EmaUserLeftModel("EMA"),
                EmaUserRightModel(6)
        )
    }


    override val initialViewState: EmaUserState = EmaUserState()


    fun onActionUserClicked(item: EmaUserItemModel) {
        val eventID = when (item.type) {
            EmaUserItemModel.Type.LEFT -> {
                toolbarViewModel?.setToolbarTitle((item as EmaUserLeftModel).name)
                SINGLE_EVENT_USER
            }
            EmaUserItemModel.Type.RIGHT -> {
                toolbarViewModel?.setToolbarTitle(resourceManager.getNumberPeople((item as EmaUserRightModel).number))
                SINGLE_EVENT_GROUP
            }
        }

        notifySingleEvent(EmaExtraData(eventID, item))
    }

    override fun onCleared() {
        //To restore the default title, if not next time activity goes to foreground, this title
        //will be set in the toolbar
        toolbarViewModel?.setToolbarTitle(null)
        super.onCleared()
    }
}
