package com.orionft.clinicnutri.utils

import android.text.TextUtils

class StringValidatorUtils {

    companion object {
        fun validateEmail(email: String): Boolean {
            if (TextUtils.isEmpty(email)) {
                return false;
            } else {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        }

        fun validatePassword(password: String): Boolean {
            return (!TextUtils.isEmpty(password) && password.length >= 4)
        }

        fun validatePhone(phone: String): Boolean {
            return true
        }
    }
}