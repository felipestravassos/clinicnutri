package com.orionft.clinicnutri.ui.createaccount

import androidx.lifecycle.ViewModel
import com.orionft.clinicnutri.R
import com.orionft.clinicnutri.utils.SingleLiveEvent
import com.orionft.clinicnutri.utils.StringValidatorUtils

class CreateAccountViewModel : ViewModel() {

    val errorMsgEvent = SingleLiveEvent<Int>()
    val nextEvent: SingleLiveEvent<Int> = SingleLiveEvent()
    val previousEvent: SingleLiveEvent<Void> = SingleLiveEvent()
    val newUser = EntityUser()

    fun onClickNextPersonalInfo() {
        newUser.genderCode = when(newUser.gender) {
            R.id.female -> "F"
            R.id.male -> "M"
            R.id.other -> "O"
            else -> "INVALID GENDER"
        }

        if (newUser.genderCode.equals("INVALID GENDER")) {
            errorMsgEvent.postValue(R.string.create_account_err_gender)
        } else if (newUser.name.isNullOrEmpty() || newUser.name.length < 4) {
            errorMsgEvent.postValue(R.string.create_account_err_name)
        } else {
            nextEvent.postValue(R.id.action_personalInfFragment_to_contactFragment)
        }
    }

    fun onClickPrevious() {
        previousEvent.call()
    }

    fun onClickNextContact() {
        if (!StringValidatorUtils.validateEmail(newUser.email)) {
            errorMsgEvent.postValue(R.string.create_account_err_email)
        } else if (!StringValidatorUtils.validatePhone(newUser.phone)) {
            errorMsgEvent.postValue(R.string.create_account_err_phone)
        } else {
            nextEvent.postValue(R.id.action_contactFragment_to_addressFragment2)
        }
    }

}

class EntityUser {
    var name = ""
    var gender = 0
    var genderCode = ""
    var email = ""
    var phone = ""
}