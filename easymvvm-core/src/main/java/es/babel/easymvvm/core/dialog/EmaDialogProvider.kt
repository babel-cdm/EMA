package es.babel.easymvvm.core.dialog

/**
 * Abstract class to show a dialog
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
interface EmaDialogProvider {

    fun show(dialogData: EmaDialogData?=null, tag: String? = null)
    fun hide()
    var dialogListener: EmaDialogListener?


}