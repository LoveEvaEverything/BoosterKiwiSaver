package com.booster.investortypescheck.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.booster.investortypescheck.view.observer.LoginObserver

/**
 * Login page.
 * Created by sgao on 22/11/2021 11:27
 *
 * @author sgao
 */
class LoginActivity : FragmentActivity() {

    lateinit var workUtil:LoginObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workUtil = LoginObserver(this)
        lifecycle.addObserver(workUtil)
    }


    fun moveToMainPage() {
        val i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
    }

    fun changeButtonText() {
        workUtil.data.loginButtonName = "Changed";
    }


}