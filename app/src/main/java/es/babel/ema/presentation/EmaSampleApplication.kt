package es.babel.ema.presentation

import es.babel.easymvvm.android.base.EmaApplication
import es.babel.ema.presentation.injection.appInjection
import es.babel.injection.appDataInjection
import org.kodein.di.Kodein

/**
 * Project: Ema
 * Created by: cmateob on 21/1/19.
 */
class EmaSampleApplication : EmaApplication() {
    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module? {
        kodein.import(appDataInjection())
        return appInjection(this)
    }
}