package es.babel.easymvvm.android.ui.dialog

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.core.dialog.EmaDialogData
import es.babel.easymvvm.core.dialog.EmaDialogListener
import es.babel.easymvvm.core.dialog.EmaDialogProvider

/**
 * Simple dialog implementation
 *
 * <p>
 * Copyright (C) 2018Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:carlos.mateo@babel.es">Carlos Mateo Benito</a>
 */
abstract class EmaBaseDialogProvider constructor(private val fragmentManager: FragmentManager) : EmaDialogProvider {

    private var dialog: EmaBaseDialog<EmaDialogData>? = null

    abstract fun generateDialog(): EmaBaseDialog<*>

    override fun show(dialogData: EmaDialogData?) {

        if(dialog==null)
            dialog = generateDialog() as EmaBaseDialog<EmaDialogData>

        dialog?.let { dialog ->
            dialog.dialogListener = dialogListener
            dialog.data = dialogData
            if(!dialog.isVisible)
                dialog.show(fragmentManager,javaClass.canonicalName.hashCode().toString())

        }
    }

    override fun hide() {
        dialog?.let {
            if(!it.isHidden) {
                Log.d(this.javaClass.name,"Loading dialog totally hidden")
                it.dismissAllowingStateLoss()
            }
        }
        dialog = null
    }

    override var dialogListener: EmaDialogListener? = null
            set(value) {
                field = value
                dialog?.dialogListener = value
            }
}