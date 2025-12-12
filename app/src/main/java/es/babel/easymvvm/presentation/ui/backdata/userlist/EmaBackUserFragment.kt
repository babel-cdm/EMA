package es.babel.easymvvm.presentation.ui.backdata.userlist;

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.checkVisibility
import es.babel.easymvvm.android.extension.viewBinding
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.databinding.FragmentBackBinding
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.ui.backdata.EmaBackNavigator
import org.kodein.di.generic.instance

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 * <p>
 * Date: 2019-11-07
 */

class EmaBackUserFragment : BaseFragment<EmaBackUserState, EmaBackUserViewModel, EmaBackNavigator.Navigation>() {

    override val layoutId: Int  = R.layout.fragment_back
    private val binding by viewBinding(FragmentBackBinding::bind)

    private val adapter : EmaBackUserAdapter by lazy { EmaBackUserAdapter() }

    override fun onInitialized(viewModel: EmaBackUserViewModel) {
        setupRecycler()
        setupButton(viewModel)
    }

    private fun setupButton(viewModel: EmaBackUserViewModel) {
        binding.bBack.setOnClickListener {
            viewModel.onActionAddUser()
        }
    }

    private fun setupRecycler() = with(binding) {
        rvBack.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        rvBack.adapter = adapter
    }

    override val fragmentViewModelScope: Boolean = true

    override val viewModelSeed: EmaBackUserViewModel by instance()

    override val navigator: EmaBackNavigator by instance()

    override fun onNormal(data: EmaBackUserState) = with(binding) {
        adapter.updateList(data.listUsers)
        tvBackNoUsers.visibility = checkVisibility(data.noUserVisibility)
        rvBack.visibility = checkVisibility(!data.noUserVisibility, gone = false)
    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingle(data: EmaExtraData) {

    }

    override fun onError(error: Throwable) {

    }

    override fun onNormalFirstTime(data: EmaBackUserState) {

    }

}
