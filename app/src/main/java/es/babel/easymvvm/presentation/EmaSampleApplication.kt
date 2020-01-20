package es.babel.easymvvm.presentation

import es.babel.easymvvm.android.base.EmaApplication
import es.babel.easymvvm.presentation.injection.appInjection
import es.babel.injection.appDataInjection
import org.kodein.di.Kodein

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 21/1/19.
 */
class EmaSampleApplication : EmaApplication() {
    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module? {
        kodein.import(appDataInjection())
        return appInjection(this)
    }
}