package com.booster.investortypescheck.view.fragment;

import android.view.LayoutInflater;
import android.widget.TextView;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;

public class QuestionFragment extends BaseFragment {

    TextView titleTV;

    int currentNum = 1;
    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.question_layout,null);
        titleTV = rootView.findViewById(R.id.question_title_tv);
    }

    @Override
    public void loadData() {

        String[] questionList = getResources().getStringArray(R.array.question);
        String[] answer01List = getResources().getStringArray(R.array.question01_answer);
        String[] answer02List = getResources().getStringArray(R.array.question02_answer);
        String[] answer03List = getResources().getStringArray(R.array.question03_answer);
        String[] answer04List = getResources().getStringArray(R.array.question04_answer);
        String[] answer05List = getResources().getStringArray(R.array.question05_answer);

    }



    private void refreshData(){
        
    }
}
