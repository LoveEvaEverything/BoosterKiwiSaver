package com.booster.investortypescheck.view.observer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booster.investortypescheck.view.entities.Login
import com.booster.investortypescheck.view.entities.LoginLiveData

/**
 * Created by sgao on 24/11/2021 16:12
 **/
class LoginViewModel(var count: Int) : ViewModel() {


    var liveData: MutableLiveData<LoginLiveData> =  MutableLiveData<LoginLiveData>()

    fun getCountData():Int{
        return liveData.value!!.count
    }

    init {
        liveData.value = LoginLiveData("Login","Change text", count)
    }

    fun add() {
        liveData.value!!.count ++
        liveData.postValue(liveData.value)
    }

    fun changeButtonText() {
        liveData.value!!.loginButtonName = "Changed";
        liveData.postValue(liveData.value)
    }


}