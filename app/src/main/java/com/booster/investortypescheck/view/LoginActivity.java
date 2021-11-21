package com.booster.investortypescheck.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.booster.investortypescheck.R;

/**
 * Login page.
 * Created by sgao on 22/11/2021 11:27
 *
 * @author sgao*/

public class LoginActivity extends FragmentActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        Button login = findViewById(R.id.login_bt);
        login.setOnClickListener(v -> moveToMainPage());
    }


    private void moveToMainPage()
    {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
