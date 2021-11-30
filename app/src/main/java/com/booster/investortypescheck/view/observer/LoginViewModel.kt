package com.booster.investortypescheck.view.observer

import android.util.Log
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import com.booster.investortypescheck.view.http.HttpUtil
import kotlinx.coroutines.*
import androidx.lifecycle.LiveData





/**
 * Created by sgao on 24/11/2021 16:12
 **/
@DelicateCoroutinesApi
class LoginViewModel(var count: Int) : ViewModel() {
    val liveNumber: MutableLiveData<Int> =  MutableLiveData<Int>()
    var liveData: MutableLiveData<LoginLiveData> =  MutableLiveData<LoginLiveData>()

    fun getCountData():Int{
        return liveNumber.value!!
    }
    init {
        liveNumber.value = count
    }

    fun autoLogin() {
        viewModelScope.launch {
            loginComms()
            delay(3000L)
        }
    }



    fun countDown() {
        liveNumber.postValue( liveNumber.value as Int -1)
    }


    private fun loginComms() {
        liveData.postValue(HttpUtil().getData().value)
    }

}