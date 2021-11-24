package com.booster.investortypescheck.view.observer

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.booster.investortypescheck.R
import com.booster.investortypescheck.databinding.LoginLayoutBinding
import com.booster.investortypescheck.view.LoginActivity
import com.booster.investortypescheck.view.entities.Login


/**
 * Created by sgao on 24/11/2021 14:22
 *
 * @author sgao
 */
class LoginObserver (private var viewModel: LoginViewModel): LifecycleObserver {
    private var whetherToCount = true
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        whetherToCount = true
        Thread {
            while (whetherToCount) {
                try {
                    Thread.sleep(1000)
                    viewModel.add()
                    Log.d(TAG, "start: ${viewModel.getCountData()}")
                    if (viewModel.getCountData() > 110)
                        whetherToCount = false
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