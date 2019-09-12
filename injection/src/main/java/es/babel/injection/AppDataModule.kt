package es.babel.injection

import es.babel.domain.repository.Repository
import es.babel.domain.usecase.LoginUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */

fun appDataInjection() = Kodein.Module(name = "AppDataModule") {

   bind<Repository>() with singleton { es.babel.data.repository.MockRepository() }

   bind<LoginUseCase>() with provider { LoginUseCase(instance()) }
}