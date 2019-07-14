package es.babel.easymvvm.testing.android.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import es.babel.easymvvm.android.viewmodel.EmaBaseViewModel
import es.babel.easymvvm.testing.core.EmaTest
import es.babel.easymvvm.testing.core.concurrency.TestDefaultConcurrencyManager
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Class for testing a View Model. Provide the execution threads for asynchronous task to make the
 * code testable
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class EmaViewModelTest<VM : EmaBaseViewModel<*, *>> : EmaTest(){

    protected val vm: VM by lazy {
        onSetupViewModel()
    }

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    override fun setup() {
        super.setup()
        vm.concurrencyManager = TestDefaultConcurrencyManager()
    }

    abstract fun onSetupViewModel(): VM


}