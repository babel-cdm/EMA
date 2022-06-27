package es.babel.easymvvm.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

/**
 *
 * Abstract base class to implement Kodein framework in activity context
 * to handle dependency injection
 *
 */
abstract class EmaBaseActivityBinding : AppCompatActivity(), NavHost, KodeinAware {

    private val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        injectActivityModule(this)?.let {
            import(it)
        }
    }

    /**
     * The onCreate base will inject dependencies and views.
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateActivity(savedInstanceState)
    }

    /**
     * Method called once the content view of activity has been set
     * @param savedInstanceState Instance state for activity recreation
     */
    abstract fun onCreateActivity(savedInstanceState: Bundle?)

    /**
     * The child classes implement this methods to return the module that provides the activity scope objects
     * @param kodein The kodein object which provide the injection
     * @return The Kodein module which makes the injection
     */
    abstract fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module?
}