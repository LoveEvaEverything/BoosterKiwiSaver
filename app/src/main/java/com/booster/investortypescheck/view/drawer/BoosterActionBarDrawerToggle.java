package com.booster.investortypescheck.view.drawer;

import android.app.Activity;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.booster.investortypescheck.R;


public class BoosterActionBarDrawerToggle extends ActionBarDrawerToggle {

    private final Activity mActivity;


    public BoosterActionBarDrawerToggle(Activity mActivity, DrawerLayout mDrawerLayout) {
        super(mActivity, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        this.mActivity = mActivity;
    }

    @Override
    public void onDrawerClosed(View view) {
        mActivity.invalidateOptionsMenu(); // creates call to
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        if( mActivity.getActionBar()!=null) {
            mActivity.getActionBar().setTitle("D booster");
        }
        mActivity.invalidateOptionsMenu(); // creates call to
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        super.onDrawerSlide(drawerView, 0);//close the animation
    }
}
