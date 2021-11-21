package com.booster.investortypescheck.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;
import com.booster.investortypescheck.view.base.InvestorTypeFactory;

import java.util.ArrayList;

import static com.booster.investortypescheck.model.InvestorType.AGGRESSIVE_GROWTH;
import static com.booster.investortypescheck.model.InvestorType.BALANCED;
import static com.booster.investortypescheck.model.InvestorType.BALANCE_GROWTH;
import static com.booster.investortypescheck.model.InvestorType.CONSERVATIVE;
import static com.booster.investortypescheck.model.InvestorType.DEFENSIVE;
import static com.booster.investortypescheck.model.InvestorType.GROWTH;

@SuppressLint({"SetTextI18n","CutPasteId"})
public class QuestionFragment extends BaseFragment {

    TextView titleTV;
    String type;
    String[] questionList;
    String[] answer01List;
    String[] answer02List;
    String[] answer03List;
    String[] answer04List;
    String[] answer05List;
    TextView questionTitleTV;
    LinearLayout questionLayout;
    LinearLayout answerLayout;
    LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
    LinearLayout.LayoutParams paramsResult =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);

    int currentScore;
    int totalScore;
    private Button nextBt;
    private TextView questionTV;
    ArrayList<Button> buttonList = new ArrayList<>();
    int[] scoreList = {1,3,5,7,10};
    int currentNum = 1;

    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.question_layout,null);
        titleTV = rootView.findViewById(R.id.question_title_tv);
        questionTV = rootView.findViewById(R.id.question_tx);
        questionLayout = rootView.findViewById(R.id.question_layout);
        nextBt = rootView.findViewById(R.id.next_bt);
        questionTitleTV = rootView.findViewById(R.id.question_title_tv);
        answerLayout = rootView.findViewById(R.id.answer_layout);
        nextBt.setOnClickListener(v -> nextProcess());
    }


    private void nextProcess() {
        if(currentScore == 0) {
            Toast.makeText(getContext(),"Please choose an answer.",Toast.LENGTH_SHORT).show();
            return;
        }
        totalScore +=currentScore;
        if(currentNum >= questionList.length) {
            loadResultPage();
        } else{
            currentNum++;
            refreshData();
        }
    }


    public void loadResultPage() {
        questionLayout.removeAllViews();
        addText("Your Total Score is "+ totalScore);
        addText("You are a "+ getInvestorType() + " investor.");
        nextBt.setText("SHOW");
    }


    private String getInvestorType()
    {
        if(totalScore >=5 && totalScore<=12) {
            return DEFENSIVE.toString();
        }else if(totalScore >=13 && totalScore<=20){
            return CONSERVATIVE.toString();
        }else if(totalScore >=21 && totalScore<=29){
            return BALANCED.toString();
        }else if(totalScore >=30 && totalScore<=37){
            return BALANCE_GROWTH.toString();
        }else if(totalScore >=38 && totalScore<=44){
            return GROWTH.toString();
        }else if(totalScore >=45 && totalScore<=50){
            return AGGRESSIVE_GROWTH.toString();
        }
        return "";
    }

    private void addText(String text) {
        TextView textView = new TextView(getActivity());
        textView.setText(text);
        textView.setTextSize(30);
        paramsResult.setMargins(50,100,50,100);
        textView.setLayoutParams(params);
        questionLayout.addView(textView);
    }

    @Override
    public void loadData() {

        questionList = getResources().getStringArray(R.array.question);
        answer01List = getResources().getStringArray(R.array.question01_answer);
        answer02List = getResources().getStringArray(R.array.question02_answer);
        answer03List = getResources().getStringArray(R.array.question03_answer);
        answer04List = getResources().getStringArray(R.array.question04_answer);
        answer05List = getResources().getStringArray(R.array.question05_answer);
        refreshData();
    }



    private void refreshData(){
        currentScore =0;
        answerLayout.removeAllViews();
        questionTitleTV.setText("Question " + currentNum + " :");
        questionTV.setText(questionList[currentNum-1]);
        switch (currentNum) {
            case 1:
                setAnswerData(answer01List);
                break;
            case 2:
                setAnswerData(answer02List);
                break;
            case 3:
                setAnswerData(answer03List);
                break;
            case 4:
                setAnswerData(answer04List);
                break;
            case 5:
                setAnswerData(answer05List);
                break;

        }
    }


    private void setAnswerData(String[] mData)
    {
        for (int i = 0; i <mData.length; i++) {
            addButton(mData[i],scoreList[i]);
        }
    }


    private void addButton(String text, int score) {
        Button button = new Button(getActivity());
        button.setText(text);
        button.setTextSize(18);
        params.setMargins(10,10,10,10);
        button.setLayoutParams(params);
        answerLayout.addView(button);
        button.setOnClickListener(v -> {
            currentScore = score;
            for (Button bt:buttonList) {
                bt.setBackgroundColor(Color.parseColor("#9ed07c"));
            }
            button.setBackgroundColor(Color.parseColor("#007fc4"));
        });
        button.setBackgroundColor(Color.parseColor("#9ed07c"));

        buttonList.add(button);
    }
}
