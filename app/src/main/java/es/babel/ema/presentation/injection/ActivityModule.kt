package es.babel.ema.presentation.injection

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider
import es.babel.ema.presentation.dialog.loading.LoadingDialogProvider
import es.babel.ema.presentation.dialog.simple.SimpleDialogProvider
import es.babel.ema.presentation.ui.error.EmaErrorViewModel
import es.babel.ema.presentation.ui.error.EmaToolbarViewModel
import es.babel.ema.presentation.ui.home.EmaHomeActivity
import es.babel.ema.presentation.ui.home.EmaHomeNavigator
import es.babel.ema.presentation.ui.home.EmaHomeViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */

fun activityInjection(activity: Activity) = Kodein.Module(name = "ActivityModule") {

    bind<Activity>() with singleton { activity }

    bind<EmaToolbarViewModel>() with singleton { EmaToolbarViewModel() }


}