package com.booster.investortypescheck.view.base;


import static com.booster.investortypescheck.view.base.FragmentType.INTRODUCTION_PAGE;
import static com.booster.investortypescheck.view.base.FragmentType.QUESTION_PAGE;

public class FragmentFactory {

    public BaseFragment getFragment(FragmentType type){
        if(type == null){
            return null;
        }
        if(type.equals(INTRODUCTION_PAGE)){
            return null;
        } else if(type.equals(QUESTION_PAGE)){
            return null;
        }
        return null;
    }
}
