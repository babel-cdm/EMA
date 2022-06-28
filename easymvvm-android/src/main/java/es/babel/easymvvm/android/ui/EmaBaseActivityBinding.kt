package es.babel.easymvvm.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.viewbinding.ViewBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

/**
 *
 * Abstract base class to implement Kodein framework in activity context
 * to handle dependency injection
 *
 */
abstract class EmaBaseActivityBinding<B : ViewBinding> : AppCompatActivity(), NavHost, KodeinAware {

    lateinit var binding: B

    private val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        injectActivityModule(this)?.let {
            import(it)
        }
    }

    /**
     * The onCreate base will set the view specified in [binding] and will
     * inject dependencies and views.
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onCreateActivity(savedInstanceState)
    }

    /**
     * @return The binding that's gonna be the activity view.
     */
    protected abstract fun getViewBinding(): B

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