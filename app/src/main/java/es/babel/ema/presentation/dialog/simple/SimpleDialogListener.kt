package es.babel.ema.presentation.dialog.simple

import es.babel.easymvvm.core.dialog.EmaDialogListener

/**
 * Listener based on back OS button or confirm click
 *
 * <p>
 * Copyright (C) 2018Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:carlos.mateo@babel.es">Carlos Mateo Benito</a>
 */
interface SimpleDialogListener : EmaDialogListener {
    fun onCancelClicked()
    fun onConfirmClicked()

}