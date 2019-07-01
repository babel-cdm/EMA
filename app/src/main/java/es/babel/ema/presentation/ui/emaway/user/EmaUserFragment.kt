package es.babel.ema.presentation.ui.emaway.user

import com.carmabs.ema.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_user.*
import org.kodein.di.Kodein


class EmaUserFragment : EmaFragment<EmaUserState, EmaUserViewModel, EmaNavigationState>() {

    override val navigator: EmaNavigator<EmaNavigationState>? = null

    override val inputStateKey: String = EmaUserState::class.java.name

    override fun onInitialized(viewModel: EmaUserViewModel) {
    }

    override val fragmentViewModelScope: Boolean = true

    override fun getFragmentLayout(): Int = R.layout.fragment_user

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module? = null

    override val viewModelSeed: EmaUserViewModel = EmaUserViewModel()

    override fun onStateNormal(data: EmaUserState) {
        tvUserName.text = data.name
        tvUserSurname.text = data.surname
    }

    override fun onStateLoading(data: EmaExtraData) {
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onStateError(error: Throwable) {
    }
}
