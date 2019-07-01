package es.babel.easymvvm.core.usecase

import es.babel.easymvvm.core.concurrency.AsyncManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers

/**
 * Base class to handle every use case.
 *
 * All the logic associated to data retrieving must be done inside an use case.
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

/**
 * @param I Input. Must be the model object that the use case can use to make the request
 * @param O Output.Must be the model object that the use case must return
 * @constructor An AsyncManager must be provided to handle the background tasks
 */
abstract class EmaUseCase<I, O>(private val asyncManager: AsyncManager) {

    /**
     * Executes a function inside a background thread provided by AsyncManager
     * @return the deferred object with the return value
     */
    suspend fun execute(input: I): Deferred<O> {
        return asyncManager.async(dispatcher) { useCaseFunction(input) }
    }

    /**
     * Function to implement by child classes to execute the code associated to data retrieving.
     * It will be executed inside an AsyncTask
     */
    protected abstract suspend fun useCaseFunction(input: I): O

    /**
     * Dispatcher used for useCase execution
     */
    protected open val dispatcher: CoroutineDispatcher = Dispatchers.IO
}