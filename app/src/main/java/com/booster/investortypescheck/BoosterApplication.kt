package com.booster.investortypescheck

import android.app.Application
import com.booster.investortypescheck.view.observer.ForegroundCallbacks

/**
 * Created by sgao on 24/11/2021 15:04
 **/
class BoosterApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ForegroundCallbacks.init(this)
    }
}