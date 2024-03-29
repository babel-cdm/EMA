package es.babel.easymvvm.presentation.ui.backdata.creation

import android.widget.Toast
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.viewBinding
import es.babel.easymvvm.core.extension.checkNull
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.databinding.FragmentBackResultBinding
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.ui.backdata.EmaBackNavigator
import org.kodein.di.generic.instance

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-07
 *
 * Use of EmaEditText.
 */

class EmaBackUserCreationFragment : BaseFragment<EmaBackUserCreationState, EmaBackUserCreationViewModel, EmaBackNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_back_result
    private val binding by viewBinding(FragmentBackResultBinding::bind)

    override fun onInitialized(viewModel: EmaBackUserCreationViewModel) {
        setupButtons(viewModel)
        setupEditTexts(viewModel)
    }

    private fun setupEditTexts(viewModel: EmaBackUserCreationViewModel) = with(binding) {

        ///With EmaEditText is not necessary the following code to add a textwatcher to update the
        ///state in viewmodel

        /*
        etBackResultSurname.addTextChangedListener(object : TextWatcher {
               override fun afterTextChanged(s: Editable?) {
               }

               override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               }

               override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                   viewModel.onActionSurnameWrite(s?.toString() ?: STRING_EMPTY)
               }
        })*/

        ///Use the next code ///

        etBackResultName.setEmaTextWatcherListener {
            viewModel.onActionNameWrite(it.checkNull())
        }
        etBackResultSurname.setEmaTextWatcherListener {
            viewModel.onActionSurnameWrite(it.checkNull())
        }
    }


    private fun setupButtons(viewModel: EmaBackUserCreationViewModel) = with(binding) {
        bBackResultAccept.setOnClickListener {
            val name = etBackResultName.text.toString()
            val surname = etBackResultSurname.text.toString()
            viewModel.onActionAddUser(
                    name = name,
                    surname = surname
            )
        }
    }

    override val viewModelSeed: EmaBackUserCreationViewModel by instance()

    override val navigator: EmaBackNavigator by instance()

    override fun onNormal(data: EmaBackUserCreationState) = with(binding) {

        ///Using the EmaEditText it handles text updates to avoid infinite loops described in
        ///HomeViewFragment

        etBackResultName.setText(data.name)
        etBackResultSurname.setText(data.surname)
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
        Toast.makeText(requireContext(), data.extraData as String, Toast.LENGTH_SHORT).show()
    }

    override fun onError(error: Throwable) {

    }

    override fun onNormalFirstTime(data: EmaBackUserCreationState) {
        
    }
}