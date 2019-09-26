package es.babel.ema.presentation.ui.user


import es.babel.easymvvm.core.state.EmaBaseState

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
data class EmaUserState(val name:String = "",
                        val surname:String="",
                        val itemList:List<EmaUserItemModel> = listOf()) : EmaBaseState