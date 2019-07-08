package es.babel.easymvvm.core.dialog

/**
 * Abstract class to show a dialog
 *
 *
 * @author <a href="mailto:carlos.mateo@babel.es">Carlos Mateo Benito</a>
 */
interface EmaDialogProvider {

    fun show(dialogData: EmaDialogData?=null)
    fun hide()
    var dialogListener: EmaDialogListener?



}