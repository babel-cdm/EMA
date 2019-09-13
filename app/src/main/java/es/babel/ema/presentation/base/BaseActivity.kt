package es.babel.ema.presentation.base

import com.carmabs.ema.R
import es.babel.easymvvm.android.ui.EmaToolbarFragmentActivity
import es.babel.ema.presentation.injection.activityInjection
import org.kodein.di.Kodein

/**
 * TODO: Add a class header comment.
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseActivity : EmaToolbarFragmentActivity() {

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module? = activityInjection(this)

    override fun getNavGraph(): Int = R.navigation.navigation_ema_home
}