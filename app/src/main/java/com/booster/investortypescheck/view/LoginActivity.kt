package com.booster.investortypescheck.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.booster.investortypescheck.R
import com.booster.investortypescheck.databinding.LoginLayoutBinding
import com.booster.investortypescheck.view.observer.LoginLiveData
import com.booster.investortypescheck.view.observer.LoginObserver
import com.booster.investortypescheck.view.observer.LoginViewModel
import com.booster.investortypescheck.view.observer.LoginViewModelFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.coroutines.CoroutineContext

/**
 * Login page.
 * Created by sgao on 22/11/2021 11:27
 *
 * @author sgao
 */
@DelicateCoroutinesApi
class LoginActivity : FragmentActivity() {
    private lateinit var binding: LoginLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_layout)
        binding.activity = this
        val viewModel:LoginViewModel = ViewModelProvider(this, LoginViewModelFactory(10))[LoginViewModel::class.java]
        viewModel.liveData.observe(this, { t -> if(t.responseCode ==200) moveToMainPage() })
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


    class GlobalCoroutineExceptionHandler(private val errCode: Int, private val errMsg: String = "", private val report: Boolean = false) : CoroutineExceptionHandler {
        override val key: CoroutineContext.Key<*>
        get() = CoroutineExceptionHandler

        override fun handleException(context: CoroutineContext, exception: Throwable) {
            val msg =  exception.stackTraceToString()
            Log.e("$errCode","GlobalCoroutineExceptionHandler:${msg}")
        }
    }

}

