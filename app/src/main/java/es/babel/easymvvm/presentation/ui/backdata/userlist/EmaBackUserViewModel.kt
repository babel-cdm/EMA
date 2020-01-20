package es.babel.easymvvm.presentation.ui.backdata.userlist;

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.presentation.ui.backdata.EmaBackNavigator
import es.babel.easymvvm.presentation.ui.backdata.creation.EmaBackUserCreationViewModel

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 * <p>
 * Date: 2019-11-07
 */

class EmaBackUserViewModel : EmaViewModel<EmaBackUserState, EmaBackNavigator.Navigation>() {

    companion object {
        const val RESULT_USER_NUMBER = 1000
    }

    override val initialViewState: EmaBackUserState = EmaBackUserState()


    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun onResultListenerSetup() {
        addOnResultReceived(EmaBackUserCreationViewModel.RESULT_USER){
            updateToNormalState {
                val mutableList = listUsers.toMutableList()
                mutableList.add(it.data as EmaBackUserModel)
                addResult(mutableList.size, RESULT_USER_NUMBER)
                copy(listUsers = mutableList,noUserVisibility = mutableList.isEmpty())
            }
        }
    }

    fun onActionAddUser() {
        navigate(EmaBackNavigator.Navigation.Result)
    }


}
