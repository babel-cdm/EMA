package es.babel.easymvvm.presentation.dialog.loading

import android.view.View
import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.databinding.DialogLoadingBinding

/**
 * Simple dialog
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
class LoadingDialog : EmaBaseDialog<LoadingDialogData>() {

    override val layoutId: Int = R.layout.dialog_loading

    override fun setupData(data: LoadingDialogData, view: View) {

        val binding = DialogLoadingBinding.bind(view)

        with(binding) {
            tvDialogLoadingTitle.text = data.title
            tvDialogLoadingMessage.text = data.message
        }

        isCancelable = false
        
    }
}