package es.babel.easymvvm.android.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import es.babel.easymvvm.android.viewmodel.EmaFactory
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaState


/**
 * Base fragment to bind and unbind view model
 *
 * <p>
 * Copyright (C) 2018Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
abstract class EmaFragment<S : EmaBaseState, VM : EmaViewModel<S, NS>, NS : EmaNavigationState> : EmaBaseFragment(), EmaView<S, VM, NS> {

    /**
     * The view model of the fragment
     */
    private var vm: VM? = null

    /**
     * The key id for incoming data through Bundle in fragment instantiation.This is set up when other fragment/activity
     * launches a fragment with arguments provided by Bundle
     */
    abstract val inputStateKey: String?

    /**
     * Called once the view model is instantiated
     * @param viewModel instantiated
     */
    abstract fun onInitialized(viewModel: VM)

    /**
     * The incoming state in fragment instantiation. This is set up when other fragment/activity
     * launches a fragment with arguments provided by Bundle
     */
    override val inputState: S? by lazy { getInState() }

    /**
     * The map which handles the view model attached with their respective scopes, to unbind the observers
     * when the view fragment is destroyed
     */
    private val extraViewModelMap: HashMap<EmaViewModel<*, *>, LifecycleOwner> by lazy { HashMap<EmaViewModel<*,*>,LifecycleOwner>() }

    /**
     * The view model is instantiated on fragment creation
     * @param view which inflated the fragment
     * @param savedInstanceState saved data for recreation
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            initializeViewModel(it,
                    if (fragmentViewModelScope)
                        this
                    else
                        null)
        }

    }

    /**
     * Add a view model observer to current fragment
     * @param viewModelAttachedSeed is the view model seed will used as factory instance if there is no previous
     * view model retained by the OS
     * @param fragment the fragment scope
     * @param fragmentActivity the activity scope, if it is provided this will be the scope of the view model attached
     * @param observerFunction the observer of the view model attached
     * @return The view model attached
     */
    protected fun <AS, VM : EmaViewModel<AS, *>> addExtraViewModel(
            viewModelAttachedSeed: VM,
            fragment: Fragment,
            fragmentActivity: FragmentActivity? = null,
            observerFunction: (attachedState: EmaState<AS>) -> Unit): VM {
        val viewModel = ViewModelProviders.of(requireActivity(), EmaFactory(viewModelAttachedSeed))[viewModelAttachedSeed::class.java]
        val scope: LifecycleOwner = fragmentActivity ?: fragment
        viewModel.getObservableState().observe(scope, Observer(observerFunction))
        extraViewModelMap[viewModel] = scope

        return viewModel
    }

    /**
     * Determine if the view model lifecycle is attached to the Activity or to the Fragment
     */
    abstract val fragmentViewModelScope: Boolean

    /**
     * Methods called when view model has been created
     * @param viewModel
     */
    override fun onViewModelInitalized(viewModel: VM) {
        vm = viewModel
        onInitialized(viewModel)
    }

    /**
     * Destroy the view and unbind the observers from view model
     */
    override fun onDestroyView() {
        super.onDestroyView()
        val owner: LifecycleOwner = if (fragmentViewModelScope) this else requireActivity()
        removeExtraViewModels()
        vm?.unBindObservables(owner)
    }

    /**
     * Remove extra view models attached
     */
    private fun removeExtraViewModels() {
        extraViewModelMap.forEach {
            val viewModel = it.key
            val scope = it.value
            viewModel.unBindObservables(scope)
        }
        extraViewModelMap.clear()
    }

    /**
     * Get the incoming state from another fragment/activity by the key [inputStateKey] provided
     */
    private fun getInState(): S? {
        return arguments?.let {
            if (it.containsKey(inputStateKey)) {
                it.get(inputStateKey) as? S

            } else
                null
        }
    }

    fun setInputState(inState: S) {
        arguments = Bundle().apply { putSerializable(inputStateKey, inState) }
    }
}