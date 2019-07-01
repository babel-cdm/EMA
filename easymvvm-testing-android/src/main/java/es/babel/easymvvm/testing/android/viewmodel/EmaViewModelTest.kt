package es.babel.easymvvm.testing.android.viewmodel

/**
 * Class for testing a View Model. Provide the execution threads for asynchronous task to make the
 * code testable
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

/*abstract class EmaViewModelTest<VM : EmaBaseViewModel<*, *>> : EmaTest(){

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


}*/