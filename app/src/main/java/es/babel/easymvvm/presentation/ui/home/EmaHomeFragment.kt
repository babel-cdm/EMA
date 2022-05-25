package es.babel.easymvvm.presentation.ui.home

import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.TextView
import android.widget.Toast
import es.babel.domain.exception.LoginException
import es.babel.domain.exception.PasswordEmptyException
import es.babel.domain.exception.UserEmptyException
import es.babel.easymvvm.R
import es.babel.easymvvm.android.extension.checkUpdate
import es.babel.easymvvm.android.extension.viewBinding
import es.babel.easymvvm.core.constants.INT_ZERO
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.databinding.FragmentHomeBinding
import es.babel.easymvvm.presentation.DIALOG_TAG_LOADING
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.dialog.loading.LoadingDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogListener
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogProvider
import org.kodein.di.generic.instance

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 *
 * Use of bindForUpdate and checkUpdate
 * Use of ReceiverListener
 */
class EmaHomeFragment : BaseFragment<EmaHomeState, EmaHomeViewModel, EmaHomeNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_home
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override val viewModelSeed: EmaHomeViewModel by instance()

    override val navigator: EmaHomeNavigator  by instance()

    //As we can see we can use an instance by kodein or generate it by class instance
    @Suppress("DEPRECATION")
    private val errorDialog: EmaDialogProvider by lazy { SimpleDialogProvider(requireFragmentManager()) }

    private val loadingDialog: EmaDialogProvider by instance(tag = DIALOG_TAG_LOADING)
    /////////////////////////////////////////////////////////////////////////////////

    override fun onInitialized(viewModel: EmaHomeViewModel) {
        setupButtons(viewModel)
        setupDialog(viewModel)
    }

    private fun setupDialog(viewModel: EmaHomeViewModel) {
        errorDialog.dialogListener = object : SimpleDialogListener {
            override fun onCancelClicked() {
                viewModel.onActionDialogErrorCancel()
            }

            override fun onBackPressed() {
                viewModel.onActionDialogErrorCancel()
            }

            override fun onConfirmClicked() {
                viewModel.onActionDialogErrorAccept()
            }

        }
    }

    private fun setupButtons(viewModel: EmaHomeViewModel) = with(binding) {
        swLightLoginRememberPassword.setOnCheckedChangeListener { _, isChecked -> viewModel.onActionRemember(isChecked) }
        layoutLightLoginCarPlate.ivHomeTouchEmptyUser.setOnClickListener { viewModel.onActionDeleteUser() }
        layoutLightLoginTitular.ivHomePassEmptyPassword.setOnClickListener { viewModel.onActionDeletePassword() }
        layoutLightLoginTitular.ivHomePassSeePassword.setOnClickListener { viewModel.onActionShowPassword() }
        layoutLightLoginCarPlate.etUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                //Always the text is changed it has to be notified to ViewModel to update its state
                viewModel.onActionUserWrite(s?.toString() ?: STRING_EMPTY)
            }
        })
        layoutLightLoginTitular.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                //Always the text is changed it has to be notified to ViewModel to update its state
                viewModel.onActionPasswordWrite(s?.toString() ?: STRING_EMPTY)
            }

        })
        bLightLoginSign.setOnClickListener {
            viewModel.onActionLogin()
        }
    }

    private fun checkError(textView: TextView) {
        textView.visibility = View.VISIBLE
    }

    private fun hideErrors() = with(binding) {
        tvLightLoginErrorUser.visibility = View.GONE
        tvLightLoginErrorPassword.visibility = View.GONE
        errorDialog.hide()
    }

    private fun hideLoading() {
        loadingDialog.hide()
    }

    private fun showErrorDialog() {
        errorDialog.show(SimpleDialogData(
                getString(R.string.home_invalid_credentials_title),
                getString(R.string.home_invalid_credentials_message),
                accept = getString(R.string.dialog_accept)
        ))
    }

    private fun showLoadingDialog() {
        loadingDialog.show(
                LoadingDialogData(
                        getString(R.string.home_loading_title),
                        getString(R.string.home_loading_title_message)
                ))
    }


    override fun onNormal(data: EmaHomeState) = with(binding) {

        //We hide the dialogs in normal state
        hideErrors()
        hideLoading()


        //////THIS TWO METHODS ARE SIMILAR, USE IT DEPENDING YOUR USE CASE/////

        //Use this to check if values are different, this way you avoid to call ViewModel
        //due to TextWatcher and the chance to generate infinite loop:
        //Example : etUser change s
        // -> TextWatcher calls viewmodel
        // -> Viewmodel update the view
        // -> etUser set the data.userName
        // -> TextWatcher calls viewmodel
        // -> ¡INFINITE LOOP!
        //
        checkUpdate(layoutLightLoginCarPlate.etUser.text.toString(),data.userName) {
            layoutLightLoginCarPlate.etUser.setText(data.userName)
        }

        //Use this to execute the set view value operation only if the selected state property has been
        //updated.
        //This could be very use to execute animations on views, this way the animation only will be executed
        //when the value has been updated, not everytime state view is updated.


        bindForUpdate(data::userPassword) {
            layoutLightLoginTitular.etPassword.setText(data.userPassword)
        }

        //////////////////////////////////////////////////////////////////////

        swLightLoginRememberPassword.isChecked = data.rememberUser

        data.showPassword.let {

            with(layoutLightLoginTitular) {
                if (it) {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                } else {
                    etPassword.transformationMethod = null

                }
                etPassword.setSelection(etPassword.text.length)
            }

        }
    }

    override fun onAlternative(data: EmaExtraData) {
        showLoadingDialog()
    }

    override fun onSingle(data: EmaExtraData) {
        when (data.type) {
            EmaHomeViewModel.EVENT_MESSAGE -> Toast.makeText(requireContext(), data.extraData as String, Toast.LENGTH_LONG).show()
        }
    }

    override fun onError(error: Throwable) = with(binding) {
        when (error) {
            is UserEmptyException -> checkError(tvLightLoginErrorUser)
            is PasswordEmptyException -> checkError(tvLightLoginErrorPassword)
            is LoginException -> showErrorDialog()
        }
    }

    override fun onNormalFirstTime(data: EmaHomeState) {
        when(data.defaultTitle){
            INT_ZERO -> binding.tvLoginWelcome.text = getString(R.string.app_name)
        }
    }

}