package es.babel.easymvvm.presentation.dialog.simple

import android.view.View
import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.dialog.EmaBaseBottomSheetDialog
import es.babel.easymvvm.databinding.DialogSimpleBinding
import es.babel.easymvvm.databinding.FragmentUserBinding
import es.babel.easymvvm.databinding.ItemBackUserBinding

/**
 * Simple dialog
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
class SimpleDialog : EmaBaseBottomSheetDialog<SimpleDialogData>() {

    override val layoutId: Int = R.layout.dialog_simple

    override fun setupData(data: SimpleDialogData, view: View) {

        val binding = DialogSimpleBinding.bind(view)

        with(binding) {
            with(data){
                (dialogListener as? SimpleDialogListener)?.let { listener ->
                    bDialogSimpleNo.setOnClickListener { listener.onCancelClicked() }
                    ivDialogSimpleCross.setOnClickListener { listener.onCancelClicked() }
                    bDialogSimpleYes.setOnClickListener { listener.onConfirmClicked() }
                }

                tvDialogSimpleTitle.text = title

                if (showCross)
                    ivDialogSimpleCross.visibility = if (showCross) View.VISIBLE else View.GONE

                tvDialogSimpleMessage.text = message

                bDialogSimpleYes.text = accept

                ivDialogSimple.visibility =
                    image?.let {
                        ivDialogSimple.setImageDrawable(it)
                        View.VISIBLE
                    } ?: View.GONE

                if (cancel.isEmpty()) bDialogSimpleNo.visibility = View.GONE

                bDialogSimpleNo.text = cancel

                isCancelable = false
            }
        }

    }
}