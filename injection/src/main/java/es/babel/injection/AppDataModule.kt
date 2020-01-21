package es.babel.injection

import es.babel.data.manager.AndroidResourceManager
import es.babel.data.repository.MockRepository
import es.babel.domain.manager.ResourceManager
import es.babel.domain.repository.Repository
import es.babel.domain.usecase.LoginUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */

fun appDataInjection() = Kodein.Module(name = "AppDataModule") {

   bind<Repository>() with singleton { MockRepository() }

   bind<LoginUseCase>() with provider { LoginUseCase(instance()) }

   bind<ResourceManager>() with singleton { AndroidResourceManager(instance()) }
}