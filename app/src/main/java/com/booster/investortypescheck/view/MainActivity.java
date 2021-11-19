package com.booster.investortypescheck.view;


import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.BoosterActionBarDrawerToggle;
import com.booster.investortypescheck.view.DrawerListAdapter;

public class MainActivity extends BaseFragment {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private DrawerListAdapter mDrawerAdapter;
    private BoosterActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        mDrawerAdapter = new DrawerListAdapter(this);
        mDrawerList.setAdapter(mDrawerAdapter);

        mDrawerLayout.openDrawer(GravityCompat.START);
        mDrawerToggle = new BoosterActionBarDrawerToggle(this, mDrawerLayout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);


    }


}
