package es.babel.ema.presentation.dialog.loading

import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider

/**
 * Simple dialog implementation
 *
 * <p>
 * Copyright (C) 2018Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:carlos.mateo@babel.es">Carlos Mateo Benito</a>
 */

class LoadingDialogProvider constructor(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager)
{
    override fun generateDialog(): EmaBaseDialog<*> = LoadingDialog()
}