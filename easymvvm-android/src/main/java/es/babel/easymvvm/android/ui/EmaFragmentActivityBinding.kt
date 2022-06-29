package es.babel.easymvvm.android.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import es.babel.easymvvm.android.R

/**
 * Abstract class to handle navigation in activity
 *
 *
 */
abstract class EmaFragmentActivityBinding : EmaBaseActivityBinding<ViewBinding>() {

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setupNavigation()
    }

    /**
     * Get the nav controller to handle the navigation through navigation architecture components.
     * The nav controller must be provided by an id called "navHostFragment"
     */
    override val navController: NavController
        get() = findNavController(R.id.navHostFragment)

    /**
     * Setup the navigation path for navigation architecture components
     */
    private fun setupNavigation() {
        navController.setGraph(navGraph, intent.extras)
    }


    /**
     * Get the navigation resource for the activity [R.navigation]
     */
    abstract val navGraph: Int


    /**
     * Set up the up action navigation
     */
    override fun onSupportNavigateUp() =
            findNavController(R.id.navHostFragment).navigateUp()

    /**
     * Get the view which acts as fragment container
     */
    protected fun getContentLayout(): View {
        return findViewById(R.id.navHostFragment)
    }

    override val layoutId: Int = R.layout.ema_activity_fragment

}