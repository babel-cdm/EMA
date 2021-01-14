package es.babel.easymvvm.android.ui.dialog

import android.util.Log
import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.core.dialog.EmaBottomDialogData
import es.babel.easymvvm.core.dialog.EmaDialogData
import es.babel.easymvvm.core.dialog.EmaDialogListener
import es.babel.easymvvm.core.dialog.EmaDialogProvider

/**
 * Simple dialog implementation
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
abstract class EmaBaseBottomDialogProvider constructor(private val fragmentManager: FragmentManager) : EmaDialogProvider {

    var dialog: EmaBaseBottomSheetDialog<EmaBottomDialogData>? = null

    abstract fun generateDialog(): EmaBaseBottomSheetDialog<*>

    @Suppress("UNCHECKED_CAST")
    override fun show(dialogData: EmaDialogData?) {

        if (dialog == null)
            dialog = generateDialog() as EmaBaseBottomSheetDialog<EmaBottomDialogData>

        dialog?.let { dialog ->
            dialog.dialogListener = dialogListener
            dialog.data = dialogData as EmaBottomDialogData?
            if (!dialog.isVisible)
                dialog.show(fragmentManager, getTag())

        }
    }

    override fun hide() {
        dialog?.let {
            if (!it.isHidden) {
                Log.d(this.javaClass.name, "Alternative dialog totally hidden")
                it.dismissAllowingStateLoss()
            }
        } ?: also { _ ->
            val oldDialog = fragmentManager.findFragmentByTag(getTag())
            oldDialog?.also {
                fragmentManager.beginTransaction().remove(it).commit()
            }

        }
        dialog = null
    }

    override var dialogListener: EmaDialogListener? = null
        set(value) {
            field = value
            dialog?.dialogListener = value
        }

    private fun getTag():String{
        return javaClass.canonicalName?.hashCode().toString()
    }
}