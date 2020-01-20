package es.babel.easymvvm.presentation.dialog.loading

import android.view.View
import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import kotlinx.android.synthetic.main.dialog_loading.view.*

/**
 * Simple dialog
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
class LoadingDialog : EmaBaseDialog<LoadingDialogData>() {

    override fun getLayout(): Int {
        return R.layout.dialog_loading
    }

    override fun setupData(data: LoadingDialogData, view: View) {
        view.tvDialogLoadingTitle.text = data.title
        view.tvDialogLoadingMessage.text = data.message

        isCancelable = true
    }
}