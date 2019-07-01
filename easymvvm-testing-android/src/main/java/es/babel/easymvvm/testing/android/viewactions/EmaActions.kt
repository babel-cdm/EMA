package es.babel.easymvvm.testing.android.viewactions

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralClickAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Tap


/**
 * Class to handle custom test espresso actions
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

object EmaActions {

    fun click(): ViewAction {
        return GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER)
    }
}
