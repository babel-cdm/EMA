package es.babel.easymvvm.presentation.ui.error

import android.content.Intent
import android.view.View
import androidx.compose.material.Button
import androidx.compose.material.Text
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.viewBinding
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.databinding.FragmentErrorBinding
import es.babel.easymvvm.presentation.base.BaseFragment
import org.kodein.di.generic.instance


class EmaErrorViewFragment : BaseFragment<EmaErrorState, EmaErrorViewModel, EmaErrorNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_error
    private val binding by viewBinding(FragmentErrorBinding::bind)

    /**
     * If you wouldn't want to use dependency injection you can provide it instantiating the class.
     * Not recommended
     */
    override val viewModelSeed: EmaErrorViewModel = EmaErrorViewModel()

    private val toolbarViewModelSeed: EmaErrorToolbarViewModel by instance()

    override val navigator: EmaErrorNavigator by instance()

    override fun onInitialized(viewModel: EmaErrorViewModel) {
        viewModel.toolbarViewModel = addExtraViewModel(toolbarViewModelSeed, this, requireActivity()) {
            viewModel.onToolbarUpdated(it)
        }
        setupButtons(viewModel)
    }

    private fun setupButtons(viewModel: EmaErrorViewModel) = with(binding) {
        bErrorToolbar.setOnClickListener { viewModel.onActionToolbar() }
        bErrorAddUser.setOnClickListener { viewModel.onActionAddUser() }
        btnComposableView.setContent {
            Button(
                onClick = {
                    startActivity(Intent(requireContext(), ComposeViewActivity::class.java))
                }
            ) { Text(text = "Open Composable View") }
        }
    }

    override fun onNormal(data: EmaErrorState) {
        checkShowToolbarTriggerVisibility(data)
    }

    private fun checkShowToolbarTriggerVisibility(data: EmaErrorState) {
        binding.bErrorToolbar.visibility = if (data.showToolbarViewVisibility) View.VISIBLE else View.GONE
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onNormalFirstTime(data: EmaErrorState) {

    }
}