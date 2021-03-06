package es.babel.easymvvm.android.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import es.babel.easymvvm.android.R

/**
 * Abstract class to handle navigation in activity
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
abstract class EmaFragmentActivity : EmaBaseActivity() {

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setupNavigation()
    }

    /**
     * Get the nav controller to handle the navigation through navigation architecture components.
     * The nav controller must be provided by an id called "navHostFragment"
     */
    override fun getNavController(): NavController {

        try {
            return findNavController(R.id.navHostFragment)
        } catch (e: java.lang.RuntimeException) {
            throw RuntimeException("You must provide in your activity xml a fragment with " +
                    "android:id=@+ìd/navHostFragment as container " +
                    "with android:name=androidx.navigation.fragment.NavHostFragment")
        }

    }

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