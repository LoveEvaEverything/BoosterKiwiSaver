package com.booster.investortypescheck.view.entities

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.booster.investortypescheck.BR
/**
 * Created by sgao on 24/11/2021 10:22
 **/
class Login: BaseObservable() {
    @get:Bindable
    var loginButtonName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.loginButtonName)
        }

    @get:Bindable
    var changeButtonName: String ="ChangeText"
        set(value) {
            field = value
            notifyPropertyChanged(BR.changeButtonName)
        }
    @get:Bindable
    var count:Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }
}