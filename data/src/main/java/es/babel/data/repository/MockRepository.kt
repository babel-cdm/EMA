package es.babel.data.repository

import es.babel.domain.exception.LoginException
import es.babel.domain.model.LoginRequest
import es.babel.domain.model.User
import es.babel.domain.repository.Repository
import kotlinx.coroutines.delay


/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 19/1/19.
 */
class MockRepository : Repository {

    override suspend fun login(loginRequest: LoginRequest): User {
        delay(2000)
       if(loginRequest.name.equals("Admin",true) && loginRequest.password=="1234")
           return User("Admin", "EMA based on MVVM Architecture, powered by Carmabs")
        else throw LoginException()
    }
}