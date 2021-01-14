package es.babel.easymvvm.presentation.dialog.simple

import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.android.ui.dialog.EmaBaseBottomDialogProvider
import es.babel.easymvvm.android.ui.dialog.EmaBaseBottomSheetDialog

/**
 * Simple dialog implementation
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */

class SimpleDialogProvider constructor(fragmentManager: FragmentManager) : EmaBaseBottomDialogProvider(fragmentManager) {
    override fun generateDialog(): EmaBaseBottomSheetDialog<*> = SimpleDialog()
}