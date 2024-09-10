package es.babel.easymvvm.presentation.ui.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import es.babel.easymvvm.android.ui.EmaBaseLayoutBinding
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.databinding.CustomSwitchViewBinding

class CustomSwitchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : EmaBaseLayoutBinding<CustomSwitchViewBinding>(context, attrs, defStyleAttr) {

    private var data: Model = Model()
        set(value) {
            field = value
            if (viewsSetup)
                setupData(value)
        }

    override fun getAttributes(): IntArray? = null

    override fun inflate(context: Context) = CustomSwitchViewBinding.inflate(LayoutInflater.from(context), this, true)

    private fun setupData(data: Model) {
        binding.sSwitch.isChecked = data.checked
        binding.sSwitch.isEnabled = data.enabled
        binding.sSwitch.contentDescription = data.contentDescription
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun setup(mainLayout: View) {
        setupData(data)
        binding.sSwitch.setOnClickListener {
            setChecked(!data.checked)
            data.listener?.invoke(data.checked)
        }
        binding.sSwitch.setOnTouchListener { _, event ->
            event.actionMasked == MotionEvent.ACTION_MOVE
        }
    }

    override fun setupAttributes(ta: TypedArray) {
        // Nothing to do
    }

    fun setChecked(checked: Boolean) {
        data = data.copy(checked = checked)
    }

    fun setSwEnabled(enabled: Boolean) {
        data = data.copy(enabled = enabled)
    }

    fun setContentDescriptionText(contentDescription: String) {
        data = data.copy(contentDescription = contentDescription)
    }

    fun setListener(listener: (Boolean) -> Unit) {
        data = data.copy(listener = listener)
    }

    data class Model(
        val checked: Boolean = false,
        val enabled: Boolean = true,
        val contentDescription: String = STRING_EMPTY,
        val listener: ((Boolean) -> Unit)? = null
    )
}
