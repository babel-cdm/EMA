package es.babel.ema.domain.repository

import es.babel.ema.domain.model.LoginRequest
import es.babel.ema.domain.model.User

/**
 * TODO: Add a class header comment.
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

interface Repository {

    suspend fun login(loginRequest: LoginRequest): User
}