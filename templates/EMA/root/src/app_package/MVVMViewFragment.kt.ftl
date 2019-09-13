package ${packageName}

<#if !parentFragment?has_content>
import es.babel.easymvvm.android.ui.EmaFragment
</#if>
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class ${functionalityName}ViewFragment : <#if parentFragment?has_content>${parentFragment}<#else>EmaFragment</#if><${functionalityName}State, ${functionalityName}ViewModel, <#if navigator?has_content>${navigator}<#else>${functionalityName}Navigator</#if>.Navigation>() {

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module? = null

    override val inputStateKey: String?= null

    override val viewModelSeed: ${functionalityName}ViewModel by instance()

    override val navigator: EmaNavigator<<#if navigator?has_content>${navigator}<#else>${functionalityName}Navigator</#if>.Navigation> by instance<<#if navigator?has_content>${navigator}<#else>${functionalityName}Navigator</#if>>()

    override fun onInitialized(viewModel: ${functionalityName}ViewModel) {

    }

    override fun onStateNormal(data: ${functionalityName}State) {

    }

    override fun onStateLoading(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }


    override fun getFragmentLayout(): Int = R.layout.fragmentID
   
}