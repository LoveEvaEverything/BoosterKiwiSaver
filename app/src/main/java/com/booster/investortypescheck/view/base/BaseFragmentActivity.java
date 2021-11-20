package com.booster.investortypescheck.view.base;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import com.booster.investortypescheck.R;

public abstract class BaseFragmentActivity extends FragmentActivity implements BoosterFragment{
    public DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActionBar() != null) {
            getActionBar().setTitle("D booster");
        }
        initView(null);
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_menu).setOnMenuItemClickListener(
                item -> {
                    if(mDrawerLayout!=null) {
                        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                            mDrawerLayout.closeDrawers();
                        }else
                            mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                    return true;
                });

        return super.onCreateOptionsMenu(menu);
    }
}
