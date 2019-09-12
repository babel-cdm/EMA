package es.babel.ema.presentation.ui.home

import es.babel.domain.exception.UserEmptyException
import es.babel.domain.model.LoginRequest
import es.babel.domain.usecase.LoginUseCase
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.ema.presentation.base.BaseViewModel

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
class EmaHomeViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel<EmaHomeState, EmaHomeNavigator.Navigation>() {

    companion object{
        const val EVENT_MESSAGE = 1000
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun createInitialViewState(): EmaHomeState = EmaHomeState()

    private fun doLogin() {
        checkViewState {
            executeUseCaseWithException(
                    {
                        loading()
                        val user = loginUseCase.doLogin(LoginRequest(it.userName, it.userPassword))
                        updateViewState()
                        sendSingleEvent(EmaExtraData(EVENT_MESSAGE,"Congratulations"))
                        navigate(EmaHomeNavigator.Navigation.User(user))
                    },
                    {
                        e -> notifyError(e)
                        navigate(EmaHomeNavigator.Navigation.Error)
                    }
            )
        }
    }

    fun onActionLogin() {
        checkViewState {
            when {
                it.userName.isEmpty() -> notifyError(UserEmptyException())
                it.userPassword.isEmpty() -> notifyError(UserEmptyException())
                else -> doLogin()
            }
        }
    }

    fun onActionShowPassword() {
        updateViewState {
            copy(showPassword = !showPassword)
        }
    }

    fun onActionRemember(isChecked:Boolean) {
        updateViewState(false) {
            copy(rememberUser = isChecked)
        }
    }

    fun onActionDeletePassword() {
        updateViewState {
            copy(userPassword = "")
        }
    }

    fun onActionDeleteUser() {
        updateViewState {
            copy(userName = "")
        }
    }

    fun onActionPasswordWrite(password: String) {
        updateViewState(false) {
            copy(userPassword = password)
        }
    }

    fun onActionUserWrite(user: String) {
        updateViewState(false) {
            copy(userName = user)
        }
    }

    fun onActionDialogErrorCancel() {
        updateViewState()
    }

    fun onActionDialogErrorAccept() {
        updateViewState()
    }

}