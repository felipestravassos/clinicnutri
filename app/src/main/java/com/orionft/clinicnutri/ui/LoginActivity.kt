package com.orionft.clinicnutri.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orionft.clinicnutri.R
import com.orionft.clinicnutri.databinding.ActivityLoginBinding
import com.orionft.clinicnutri.ui.createaccount.CreateAccountActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.errorMsgEvent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.openCreateAccount.observe(this, Observer {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        })
    }
}