package es.babel.easymvvm.presentation.ui.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.getFormattedString
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import es.babel.easymvvm.databinding.ItemLeftBinding
import es.babel.easymvvm.databinding.ItemRightBinding

/**
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 *
 * Date: 2019-09-25
 */

class EmaUserAdapter(private val viewModel: EmaUserViewModel,
                     override val listItems: MutableList<EmaUserItemModel> = mutableListOf()) : EmaRecyclerAdapter<EmaUserItemModel>() {


    override fun getItemViewType(position: Int): Int {
        return listItems[position].type.id
    }

    /////////////////////////////////////////////////////////////////////////
    // SAMPLE CODE IF YOU WANT TO USE A MULTIVIEW IN ADAPTER OR CUSTOM VIEW//
    /////////////////////////////////////////////////////////////////////////

    override val layoutItemId: Int? = null

    override fun View.bind(item: EmaUserItemModel, viewType: Int) {

        val bindingLeft = ItemLeftBinding.bind(this)
        val bindingRight = ItemRightBinding.bind(this)

        when (EmaUserItemModel.getFromId(viewType)) {

            EmaUserItemModel.Type.LEFT -> {
                val leftItem = item as EmaUserLeftModel
                bindingLeft.tvItemLeft.text = R.string.user_name.getFormattedString(context,leftItem.name)
            }

            EmaUserItemModel.Type.RIGHT -> {
                val rightItem = item as EmaUserRightModel
                bindingRight.tvItemRight.text = R.string.user_number_people.getFormattedString(context,rightItem.number)
            }
        }

        setOnClickListener { viewModel.onActionUserClicked(item) }
    }


    override val enableMultiViewHolder: ((view: ViewGroup, viewType: Int) -> EmaAdapterViewHolder)? = { view, viewType ->

        when (EmaUserItemModel.getFromId(viewType)) {
            EmaUserItemModel.Type.LEFT -> EmaAdapterViewHolder(LayoutInflater.from(view.context).inflate(R.layout.item_left, view, false), viewType)
            EmaUserItemModel.Type.RIGHT -> EmaAdapterViewHolder(LayoutInflater.from(view.context).inflate(R.layout.item_right, view, false), viewType)
        }
    }

    /////////////////////////////////////////////////////////////
    // SAMPLE CODE IF YOU WANT TO USE A SINGLE VIEW IN ADAPTER //
    /////////////////////////////////////////////////////////////

    /*
    override val layoutItemId: Int? = R.layoutId.item_left

    override fun View.bind(item: EmaUserItemModel, viewType: Int) {

       var name = String()
       var color = ContextCompat.getColor(context,R.color.colorAccent)

       when(EmaUserItemModel.getFromId(viewType)){

           EmaUserItemModel.Type.LEFT -> {
               val leftItem = item as EmaUserLeftModel
               name =  String.format(context.resources.getString(R.string.user_name),leftItem.name)
           }
           EmaUserItemModel.Type.RIGHT -> {
               val rightItem = item as EmaUserRightModel
               name = String.format(context.resources.getString(R.string.user_number_people),rightItem.number)
           }
       }

       tvItemLeft.text = name
       ivItemLeft.setBackgroundColor(color)
   }
   */
}