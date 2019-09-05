package ${packageName}

<#if !parentViewModel?has_content>
import es.babel.easymvvm.android.viewmodel.EmaViewModel
</#if>


class ${functionalityName}ViewModel: <#if parentViewModel?has_content>${parentViewModel}<#else>EmaViewModel</#if><${functionalityName}State,<#if navigator?has_content>${navigator}<#else>${functionalityName}Navigator</#if>.Navigation>(){
	
	override fun onStartFirstTime(statePreloaded: Boolean) {
    
    }

   	override fun createInitialViewState(): ${functionalityName}State = ${functionalityName}State()
   
}