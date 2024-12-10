package es.babel.easymvvm.android.ui.dialog

import android.view.View
import androidx.viewbinding.ViewBinding
import es.babel.easymvvm.core.dialog.EmaDialogData

/**
 *
 * Abstract base dialog class to implement custom dialogs with View Binding.
 *
 * This class is optional, in other words, isn't mandatory inherit it from custom dialogs but
 * help to homogenize in large projects with several custom dialogs
 *
 * @author <a href=“mailto:rafa.lortiz@babelgroup.com”>Rafael Ángel Luque</a>
 */
abstract class EmaBaseDialogBinding<VB : ViewBinding, T : EmaDialogData> : EmaBaseDialog<T>() {

    /**
     * Private instance of ViewBinding that cannot be accessed directly.
     */
    private lateinit var binding: VB

    /**
     * Must invokes the bind method on the concrete View Binding class
     * This method must be not called from subclasses, only must be overrides.
     *
     * @param view View used to bind
     * @return viewBinding instance
     */
    abstract fun bind(view: View): VB

    /**
     * Get the view binding instance. If it wasn't initialized previously, this call will initialize
     * it before.
     *
     * This method must be the only way to access to the viewBinding instance.
     *
     * @param view View used to bind
     * @return viewBinding instance
     */
    protected fun getBinding(view: View): VB = when (::binding.isInitialized) {
        true -> binding
        else -> bind(view).also { binding = it }
    }
}
