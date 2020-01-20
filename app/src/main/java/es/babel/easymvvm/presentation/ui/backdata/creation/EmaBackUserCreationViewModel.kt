package es.babel.easymvvm.presentation.ui.backdata.creation

import es.babel.domain.manager.ResourceManager
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.ui.backdata.EmaBackNavigator
import es.babel.easymvvm.presentation.ui.backdata.userlist.EmaBackUserModel

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-07
 */

class EmaBackUserCreationViewModel(private val resourceManager: ResourceManager) : EmaViewModel<EmaBackUserCreationState, EmaBackNavigator.Navigation>() {

    companion object {
        const val RESULT_USER = 0
    }

    override val initialViewState: EmaBackUserCreationState = EmaBackUserCreationState()


    override fun onStartFirstTime(statePreloaded: Boolean) {
        updateToAlternativeState()
    }

    fun onActionAddUser(name: String, surname: String) {
        when {
            name.isEmpty() -> notifySingleEvent(EmaExtraData(extraData = resourceManager.getResultErrorFillName()))
            surname.isEmpty() -> notifySingleEvent(EmaExtraData(extraData = resourceManager.getResultErrorFillSurname()))
            else -> {
                addResult(EmaBackUserModel(
                        name = name,
                        surname = surname
                ), RESULT_USER)
                addResult(Pair(name, System.currentTimeMillis()))
                navigateBack()
            }
        }
    }

    fun onActionNameWrite(name: String) {
        updateToNormalState {
            copy(name = name)
        }
    }

    fun onActionSurnameWrite(surname: String) {
        updateToNormalState {
            copy(surname = surname)
        }
    }
}