package es.babel.domain.usecase

import es.babel.domain.model.LoginRequest
import es.babel.domain.model.User
import es.babel.domain.repository.Repository
import es.babel.easymvvm.core.usecase.EmaUseCase


/**
 * Login
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

class LoginUseCase(private val repository: Repository) : EmaUseCase<LoginRequest, User>() {

    override suspend fun useCaseFunction(input: LoginRequest): User {
        return repository.login(input)
    }
}