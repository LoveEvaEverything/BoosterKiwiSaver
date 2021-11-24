package com.booster.investortypescheck.view.observer

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.booster.investortypescheck.R
import com.booster.investortypescheck.databinding.LoginLayoutBinding
import com.booster.investortypescheck.view.LoginActivity
import com.booster.investortypescheck.view.entities.Login

/**
 * Created by sgao on 24/11/2021 14:22
 *
 * @author sgao
 */
class LoginObserver(private var activity: LoginActivity) : LifecycleObserver {
    private var whetherToCount = true
    lateinit var data: Login

    private lateinit var viewModel: LoginViewModel
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        val binding: LoginLayoutBinding =
            DataBindingUtil.setContentView(activity, R.layout.login_layout)
        data = Login();
        binding.logins = data
        binding.activity = activity
        data.loginButtonName = "Hello"

        viewModel = ViewModelProvider(activity)[LoginViewModel::class.java]
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        whetherToCount = true
        Thread {
            while (whetherToCount) {
                try {
                    Thread.sleep(1000)
                    viewModel.count++
                    Log.d(TAG, "start: ${viewModel.count}")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        whetherToCount = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        viewModel.count = 0
    }

    companion object {
        private const val TAG = "WorkUtil"
    }
}