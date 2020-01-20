package es.babel.domain.manager

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-08
 */

interface ResourceManager {

    fun getResultErrorFillName():String

    fun getResultErrorFillSurname():String

    fun getHomeUserToolbarTitle(): String

    fun getCongratulations(): String

    fun getNumberPeople(number: Int): String
}