package com.orionft.clinicnutri.ui

import androidx.lifecycle.ViewModel
import com.orionft.clinicnutri.R
import com.orionft.clinicnutri.repository.Server
import com.orionft.clinicnutri.utils.SingleLiveEvent
import com.orionft.clinicnutri.utils.StringValidatorUtils

class LoginViewModel : ViewModel() {

    val errorMsgEvent = SingleLiveEvent<Int>()
    val openCreateAccount = SingleLiveEvent<Void>()

    private val server = Server()

    fun onClickForgotPassword(email: String) {
        if (!StringValidatorUtils.validateEmail(email)) {
            errorMsgEvent.postValue(R.string.err_validate_email)
        } else {
            server.forgotPassword(email)
        }
    }

    fun onClickCreateAccount() {
        openCreateAccount.call()
    }

    fun onClickLogin(email: String, password: String) {
        if (!StringValidatorUtils.validateEmail(email)) {
            errorMsgEvent.postValue(R.string.err_validate_email)
        } else if (!StringValidatorUtils.validatePassword(password)) {
            errorMsgEvent.postValue(R.string.err_validate_password)
        } else {
            server.login(email, password)
        }
    }

}