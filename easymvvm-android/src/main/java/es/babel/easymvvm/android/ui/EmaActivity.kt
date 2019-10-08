package es.babel.easymvvm.android.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import es.babel.easymvvm.android.viewmodel.EmaFactory
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaState

/**
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 *
 * Date: 2019-09-26
 */

abstract class EmaActivity<S : EmaBaseState, VM : EmaViewModel<S, NS>, NS : EmaNavigationState> : EmaToolbarFragmentActivity(), EmaView<S, VM, NS> {


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
     * The incoming state in fragment instantiation. This is set up when other fragment/activity
     * launches a fragment with arguments provided by Bundle
     */
    override val inputState: S? by lazy { getInState() }


    /**
     * Initialize ViewModel on activity creation
     */
    override fun createActivity(savedInstanceState: Bundle?) {
        super.createActivity(savedInstanceState)
        initializeViewModel(this)
    }

    /**
     * Methods called when view model has been created
     * @param viewModel
     */
    override fun onViewModelInitalized(viewModel: VM) {
        vm = viewModel
        onInitialized(viewModel)
    }

    /**
     * Called once the view model is instantiated
     * @param viewModel instantiated
     */
    abstract fun onInitialized(viewModel: VM)

    /**
     * The map which handles the view model attached with their respective scopes, to unbind the observers
     * when the view activity is destroyed
     */
    private val extraViewModelMap: MutableList<EmaViewModel<*, *>> by lazy { mutableListOf<EmaViewModel<*, *>>() }


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
            fragment: Fragment? = null,
            observerFunction: ((attachedState: EmaState<AS>) -> Unit)? = null): VM {

        val viewModel =
                fragment?.let {
                    ViewModelProviders.of(it, EmaFactory(viewModelAttachedSeed))[viewModelAttachedSeed::class.java]
                }
                        ?: ViewModelProviders.of(this, EmaFactory(viewModelAttachedSeed))[viewModelAttachedSeed::class.java]

        observerFunction?.also { viewModel.getObservableState().observe(this, Observer(it)) }
        extraViewModelMap.add(viewModel)

        return viewModel
    }

    /**
     * Get the incoming state from another activity by the key [inputStateKey] provided
     */
    private fun getInState(): S? {
        return intent?.let {
            it.extras?.getSerializable(inputStateKey) as? S

        }
    }

    fun setInputState(inState: S) {
        intent = Intent().apply { putExtra(inputStateKey, inState) }
    }

    /**
     * Destroy the activity and unbind the observers from view model
     */
    override fun onDestroy() {
        super.onDestroy()
        removeExtraViewModels()
        vm?.unBindObservables(this)
    }

    /**
     * Remove extra view models attached
     */
    private fun removeExtraViewModels() {
        extraViewModelMap.forEach {
            it.unBindObservables(this)
        }
        extraViewModelMap.clear()
    }


}