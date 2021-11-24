package com.booster.investortypescheck.view.observer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by sgao on 25/11/2021 08:42
 **/
class LoginViewModelFactory(var count:Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return  LoginViewModel(count) as T;
    }
}