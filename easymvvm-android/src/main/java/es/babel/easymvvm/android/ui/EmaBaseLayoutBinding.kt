package es.babel.easymvvm.android.ui

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

/**
 *
 * Abstract base class to implement custom layouts with View Binding.
 * It handles dependency injection as well.
 *
 * @author <a href=“mailto:rafa.lortiz@babelgroup.com”>Rafael Ángel Luque</a>
 */
abstract class EmaBaseLayoutBinding<VB : ViewBinding> : FrameLayout, KodeinAware {

    override val kodein: Kodein by closestKodein()

    protected lateinit var binding: VB

    protected var viewsSetup = false

    constructor(context: Context) : super(context) {
        onCreateView(context)
    }

    constructor(ctx: Context, attrs: AttributeSet?) : super(ctx, attrs) {
        onCreateView(context, attrs)
    }

    constructor(ctx: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        ctx,
        attrs,
        defStyleAttr
    ) {
        onCreateView(context, attrs)
    }

    private fun onCreateView(context: Context, attrs: AttributeSet? = null) {
        viewsSetup = false
        binding = inflate(context)
        handleAttributes(attrs)
    }

    /**
     * Setup called once the windows has been attached
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setup(binding.root)
        viewsSetup = true
    }

    /**
     * Method called once the custom attributes has been set by [EmaBaseLayout.getAttributes]
     * @param ta are the custom attributes inflated
     */
    abstract fun setupAttributes(ta: TypedArray)

    /**
     * @return the custom attributes than can be used for the custom layout
     */
    abstract fun getAttributes(): IntArray?

    /**
     * Method called once the layout has been inflated implementing the methods [EmaBaseLayout.getLayout]
     * @param mainLayout is the layout inflated instance
     */
    abstract fun setup(mainLayout: View)

    /**
     * Method called when view is created
     * @return a View Binding instance of VB class after inflate it
     */
    protected abstract fun inflate(context: Context): VB

    /**
     * Handle the custom attributes of the view
     */
    private fun handleAttributes(set: AttributeSet?) {
        set?.let { _ ->
            val attrs = getAttributes()
            attrs?.let { _ ->
                with(context.obtainStyledAttributes(set, attrs, 0, 0)) {
                    try {
                        setupAttributes(this)
                    } finally {
                        this.recycle()
                    }
                }
            }
        }
    }
}
