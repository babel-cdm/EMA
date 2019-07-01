package es.babel.ema.presentation

import es.babel.easymvvm.android.base.EmaApplication
import org.kodein.di.Kodein

/**
 * Project: Ema
 * Created by: cmateob on 21/1/19.
 */
class EmaSampleApplication : EmaApplication() {
    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module? = null
}