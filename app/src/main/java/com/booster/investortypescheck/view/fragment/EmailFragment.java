package com.booster.investortypescheck.view.fragment;

import static com.booster.investortypescheck.view.utils.Constants.SCORE_KEY_SP;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;

/**
 * Created by sgao on 22/11/2021 09:33
 *
 * @author sgao*/
public class EmailFragment extends BaseFragment {
    private EditText nameET, emailET, phoneET;
    private Button submitBT;
    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.emai_layout,null);
        nameET = rootView.findViewById(R.id.et_name);
        emailET = rootView.findViewById(R.id.et_email);
        phoneET = rootView.findViewById(R.id.et_phone);
        submitBT =rootView.findViewById(R.id.submit_bt);

        submitBT.setOnClickListener(new SubmitClickListener());
    }


    private void submitData() {
        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        String phone = phoneET.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)) {
            Toast.makeText(getContext(),"Please fill in all the information.", Toast.LENGTH_SHORT).show();
            return;
        }else {
//        sendEmail(email,name, phone);  TODO  send email in background
            FinishSubmitFragment fragment = new FinishSubmitFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_container,fragment).commit();
        }

    }
    private class SubmitClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            submitData();
        }
    }

    public void sendEmail(String emailAddress, String name, String phone){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        emailIntent.setData(Uri.parse("mailto:" + "me@example.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "D booster data");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailAddress + name + phone);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void loadData() {

    }

}
