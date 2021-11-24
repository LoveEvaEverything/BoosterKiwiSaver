package com.booster.investortypescheck.view.observer

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * Created by sgao on 24/11/2021 14:59
 */
class ForegroundCallbacks: Application.ActivityLifecycleCallbacks {

    companion object{
        var instance: ForegroundCallbacks? = null
        fun init(application :Application): ForegroundCallbacks?{
            instance = ForegroundCallbacks()
            application.registerActivityLifecycleCallbacks(instance)
            return instance
        }
        private const val TAG = "ForegroundCallbacks"
    }
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated: "+ activity.componentName);
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(TAG, "onActivityStarted: "+ activity.componentName);
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(TAG, "onActivityResumed: "+ activity.componentName);
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(TAG, "onActivityPaused: "+ activity.componentName);
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(TAG, "onActivityStopped: "+ activity.componentName);
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(TAG, "onActivitySaveInstanceState: "+ activity.componentName);
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(TAG, "onActivityDestroyed: "+ activity.componentName);
    }

}