package es.babel.ema.presentation.ui.user

import com.carmabs.ema.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.ema.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*
import org.kodein.di.Kodein


class EmaUserFragment : BaseFragment<EmaUserState, EmaUserViewModel, EmaNavigationState>() {

    override val navigator: EmaNavigator<EmaNavigationState>? = null

    override val inputStateKey: String = EmaUserState::class.java.name

    override fun onInitialized(viewModel: EmaUserViewModel) {

    }

    override fun getFragmentLayout(): Int = R.layout.fragment_user

    override val viewModelSeed: EmaUserViewModel = EmaUserViewModel()

    override fun onNormal(data: EmaUserState) {
        tvUserName.text = data.name
        tvUserSurname.text = data.surname
    }


    override fun onLoading(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }
}
