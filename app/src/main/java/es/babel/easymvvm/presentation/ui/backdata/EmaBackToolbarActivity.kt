package es.babel.easymvvm.presentation.ui.backdata;

import androidx.core.content.ContextCompat
import es.babel.easymvvm.R
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseActivity
import org.kodein.di.generic.instance

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 * <p>
 * Date: 2019-11-07
 */

class EmaBackToolbarActivity : BaseActivity<EmaBackToolbarState, EmaBackToolbarViewModel, EmaBackNavigator.Navigation>() {

    override val navGraph: Int = R.navigation.navigation_ema_back

    override fun provideFixedToolbarTitle(): String? = null

    override val viewModelSeed: EmaBackToolbarViewModel by instance()

    override val navigator: EmaBackNavigator by instance()

    override fun onInitialized(viewModel: EmaBackToolbarViewModel) {
        toolbar.apply {
            setBackgroundColor(ContextCompat.getColor(this@EmaBackToolbarActivity, R.color.colorPrimary))
        }

    }

    override fun onStateNormal(data: EmaBackToolbarState) {

    }

    override fun onStateAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }

    override fun onStateNormalFirstTime(data: EmaBackToolbarState) {

    }
}