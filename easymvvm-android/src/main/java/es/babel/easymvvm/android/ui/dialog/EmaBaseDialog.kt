package es.babel.easymvvm.android.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.core.constants.INT_ZERO
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.dialog.EmaDialogData
import es.babel.easymvvm.core.dialog.EmaDialogListener

/**
 * Base dialog class to implement dialogs
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
abstract class EmaBaseDialog<T : EmaDialogData> : DialogFragment(), DialogInterface.OnShowListener {

    var dialogListener: EmaDialogListener? = null

    var data: T? = null
        set(value) {
            field = value
            onDataSetup(value)
        }

    private var isDismissed: Boolean = false

    private var contentView: View? = null

    protected open val disableBackButton = true

    private var previousTag: String = STRING_EMPTY


    /**
     * Specify the layout to be inflated in the [EmaBaseDialog.onCreateView].
     */
    protected abstract val layoutId: Int

    /**
     * Setup data for UI
     */
    protected abstract fun setupData(data: T, view: View)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener(this)
        dialog.setOnKeyListener { _, keyCode, event ->
            dialogListener?.let {
                if (!disableBackButton && keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
                    dismissAllowingStateLoss()
                    it.onBackPressed()
                }
            }
            false
        }

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(layoutId, container, false)
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            requestFeature(Window.FEATURE_NO_TITLE)
        }

        contentView = view

        onDataSetup(data)

        return view
    }

    @Suppress("UNCHECKED_CAST")
    private fun onDataSetup(data: Any?) {
        if (data != null) {
            (data as? T)?.apply {
                contentView?.also { view ->
                    setupData(this, view)
                }
            } ?: throw Exception("Data type not matching with the dialog")
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.also{win ->
            val display = win.windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)

            data?.run {
                val width = proportionWidth?.let { (it * size.x).toInt() }
                        ?: ViewGroup.LayoutParams.WRAP_CONTENT
                val height = proportionHeight?.let { (it * size.y).toInt() }
                        ?: ViewGroup.LayoutParams.WRAP_CONTENT
                win.setLayout(width, height)
            }
        }



    }

    override fun onShow(p0: DialogInterface?) {
        if (isDismissed)
            dismissAllowingStateLoss()
    }


    override fun show(manager: FragmentManager, tag: String?) {
        if (previousTag != tag && !tag.isNullOrEmpty()) {
            previousTag = tag
            manager.apply {
                val oldFragment = findFragmentByTag(tag)
                val ft = beginTransaction()
                oldFragment?.let { ft.remove(oldFragment) }
                ft.add(this@EmaBaseDialog, tag)
                ft.commit()
            }
        }
    }

    override fun onDestroyView() {
        contentView = null
        data = null
        dialogListener = null
        super.onDestroyView()
    }
}