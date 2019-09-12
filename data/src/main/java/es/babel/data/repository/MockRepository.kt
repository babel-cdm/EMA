package es.babel.data.repository

import es.babel.domain.exception.LoginException
import es.babel.domain.model.LoginRequest
import es.babel.domain.model.User
import es.babel.domain.repository.Repository
import kotlinx.coroutines.delay


/**
 * Project: Ema
 * Created by: cmateob on 19/1/19.
 */
class MockRepository : Repository {

    override suspend fun login(loginRequest: LoginRequest): User {
        delay(2000)
       if(loginRequest.name.equals("1234") && loginRequest.password=="1234")
           return User("Babel", "Sistemas de informacion")
        else throw LoginException()
    }
}