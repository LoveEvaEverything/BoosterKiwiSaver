package com.booster.investortypescheck.view.fragment;

import android.view.LayoutInflater;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;
import com.booster.investortypescheck.view.base.BaseFragmentActivity;

/**
 * Introduction page.explaining what the application is about and how to access the menu
 * @author sgao
 */
public class IntroductionFragment extends BaseFragment {
    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.introduction_layout,null);
    }

    @Override
    public void loadData() {

    }
}
