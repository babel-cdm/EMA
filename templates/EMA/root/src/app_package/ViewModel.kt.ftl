package ${packageName}

import es.babel.easymvvm.android.viewmodel.EmaViewModel

class ${functionalityName}ViewModel: EmaViewModel<${functionalityName}State,<#if navigator?has_content>${navigator}<#else>${functionalityName}Navigator</#if>.Navigation>(){

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun onResume(firstTime:Boolean){

    }

    override val initialViewState: ${functionalityName}State = ${functionalityName}State()

}