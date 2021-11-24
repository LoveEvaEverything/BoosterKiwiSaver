package com.booster.investortypescheck.view

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.booster.investortypescheck.R
import com.booster.investortypescheck.databinding.LoginLayoutBinding
import com.booster.investortypescheck.view.entities.Login

/**
 * Login page.
 * Created by sgao on 22/11/2021 11:27
 *
 * @author sgao
 */
class LoginActivity : FragmentActivity() {
    private lateinit var data: Login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: LoginLayoutBinding =
            DataBindingUtil.setContentView(this, R.layout.login_layout)
        data = Login();
        binding.logins = data
        binding.activity = this
        data.loginButtonName = "Hello";

    }


    fun moveToMainPage() {
        val i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
    }

    fun changeButtonText() {
        data.loginButtonName = "Changed";
    }


}