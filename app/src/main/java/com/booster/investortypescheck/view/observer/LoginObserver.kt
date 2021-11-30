package com.booster.investortypescheck.view.observer

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.DelicateCoroutinesApi


/**
 * Created by sgao on 24/11/2021 14:22
 *
 * @author sgao
 */
class LoginObserver (private var viewModel: LoginViewModel): LifecycleObserver {
    private var whetherToCount = true
    @DelicateCoroutinesApi
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        whetherToCount = true
        Thread {
            while (whetherToCount) {
                try {
                    Thread.sleep(1000)
                    viewModel.countDown()
                    if (viewModel.getCountData() <=1) {
                        viewModel.autoLogin()
                        whetherToCount = false
                    }
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

    @DelicateCoroutinesApi
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        viewModel.count = 0
    }

    companion object {
        private const val TAG = "Observer"
    }
}