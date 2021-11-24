package com.booster.investortypescheck.view

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.booster.investortypescheck.R
import com.booster.investortypescheck.databinding.LoginLayoutBinding
import com.booster.investortypescheck.view.observer.LoginObserver
import com.booster.investortypescheck.view.observer.LoginViewModel
import com.booster.investortypescheck.view.observer.LoginViewModelFactory

/**
 * Login page.
 * Created by sgao on 22/11/2021 11:27
 *
 * @author sgao
 */
class LoginActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: LoginLayoutBinding = DataBindingUtil.setContentView(this, R.layout.login_layout)
        binding.activity = this
        //        viewModel = ViewModelProvider(activity)[LoginViewModel::class.java]
        val viewModel = ViewModelProvider(this, LoginViewModelFactory(100))[LoginViewModel::class.java]
        lifecycle.addObserver(LoginObserver(viewModel))
        binding.loginModel = viewModel
        binding.activity = this
        binding.lifecycleOwner = this
    }


    fun moveToMainPage() {
        val i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
    }


}