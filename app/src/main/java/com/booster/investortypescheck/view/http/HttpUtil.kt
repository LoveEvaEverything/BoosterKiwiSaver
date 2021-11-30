package com.booster.investortypescheck.view.http

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.LiveData
import com.booster.investortypescheck.view.observer.LoginLiveData


/**
 * TODO use retrofit/OKHTTP to achieve DATA comms with server API.
 * Created by sgao on 25/11/2021 13:58
 */
class HttpUtil {
    fun getData(): LiveData<LoginLiveData> {
        //...get data from Server.
        val loginMutableLiveData: MutableLiveData<LoginLiveData> = MutableLiveData<LoginLiveData>()
        val loginData = LoginLiveData("Login Comms Finished", 200)

        loginMutableLiveData.value = loginData
        return loginMutableLiveData
    }
}