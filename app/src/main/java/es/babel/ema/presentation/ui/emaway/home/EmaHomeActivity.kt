package es.babel.ema.presentation.ui.emaway.home

import com.carmabs.ema.R
import es.babel.easymvvm.android.ui.EmaFragmentActivity
import org.kodein.di.Kodein

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
class EmaHomeActivity : EmaFragmentActivity() {

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module? = null


    override fun getNavGraph(): Int = R.navigation.navigation_ema_home


}