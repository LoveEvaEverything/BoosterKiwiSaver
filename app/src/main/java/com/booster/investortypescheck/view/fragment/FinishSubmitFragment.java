package com.booster.investortypescheck.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;

/**
 * Created by sgao on 22/11/2021 10:40
 *
 * @author sgao*/
public class FinishSubmitFragment extends BaseFragment {
    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.finished_layout,null);

        Button confirmBT = rootView.findViewById(R.id.comfirm_bt);
        confirmBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void moveToIntroductionPage()
    {

    }


    @Override
    public void loadData() {
        //TODO Dynamic changing the text.
    }
}
