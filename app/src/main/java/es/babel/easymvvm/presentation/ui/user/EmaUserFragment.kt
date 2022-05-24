package es.babel.easymvvm.presentation.ui.user

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.getFormattedString
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.databinding.FragmentUserBinding
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.extensions.viewbinding.viewBinding
import es.babel.easymvvm.presentation.ui.home.EmaHomeToolbarViewModel
import org.kodein.di.generic.instance


/**
 *  *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * The toolbar title is set up by provideFixedToolbarTitle() method
 * Use the EmaTheme because it isn,t overriden by parent activity
 * Use the EmaRecycleAdapter with multiple layout in same RecyclerView
 * Transition animation set in navigation_ema_home
 * Add extra view model to get access to EmaHomeToolbarViewModel (View model can be shared if it
 * is attached to activity scope)
 */
class EmaUserFragment : BaseFragment<EmaUserState, EmaUserViewModel, EmaNavigationState>() {

    override val layoutId: Int = R.layout.fragment_user
    private val binding by viewBinding(FragmentUserBinding::bind)

    override val navigator: EmaNavigator<EmaNavigationState>? = null

    private val toolbarViewModel: EmaHomeToolbarViewModel by instance()

    private lateinit var adapter: EmaUserAdapter

    override fun onInitialized(viewModel: EmaUserViewModel) {
        val toolbarViewModel = addExtraViewModel(toolbarViewModel,this,requireActivity())
        viewModel.toolbarViewModel = toolbarViewModel
        setupRecycler(viewModel)

    }

    private fun setupRecycler(viewModel: EmaUserViewModel) = with(binding) {
        adapter = EmaUserAdapter(viewModel)
        rvUser.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvUser.adapter = adapter
    }

    override val viewModelSeed: EmaUserViewModel by instance()

    override fun onNormal(data: EmaUserState) {
        setupRecyclerList(data)
    }

    private fun setupRecyclerList(data: EmaUserState) {
        adapter.updateList(data.itemList)
    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingle(data: EmaExtraData) {

        when (data.type) {
            EmaUserViewModel.SINGLE_EVENT_USER -> {
                val itemLeft = data.extraData as? EmaUserLeftModel
                itemLeft?.also {
                    Toast.makeText(
                            requireContext(),
                            R.string.user_hello_user.getFormattedString(requireContext(), itemLeft.name),
                            Toast.LENGTH_SHORT)
                            .show()
                }
            }

            EmaUserViewModel.SINGLE_EVENT_GROUP -> {
                val itemRight = data.extraData as? EmaUserRightModel
                itemRight?.also {
                    Toast.makeText(
                            requireContext(),
                            R.string.user_hello_group.getFormattedString(requireContext(), itemRight.number),
                            Toast.LENGTH_SHORT)
                            .show()

                }
            }
        }
    }

    override fun onError(error: Throwable) {
    }

    override fun onNormalFirstTime(data: EmaUserState) = with(binding) {
        lUserEmaHeader.tvUserName.text = data.name
        lUserEmaHeader.tvUserSurname.text = data.surname
    }
}
