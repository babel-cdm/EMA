package es.babel.ema.domain.usecase


import es.babel.ema.domain.model.LoginRequest
import es.babel.ema.domain.model.User
import es.babel.ema.domain.repository.Repository


/**
 * Login to LDA
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

class LoginUseCase(private val repository: Repository) {


    @Throws
    suspend fun doLogin(loginRequest: LoginRequest): User {
        return repository.login(loginRequest)
    }
}