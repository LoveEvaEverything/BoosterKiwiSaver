package com.booster.investortypescheck.view;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.booster.investortypescheck.R;
import com.booster.investortypescheck.view.base.BaseFragment;
import com.booster.investortypescheck.view.base.BaseFragmentActivity;
import com.booster.investortypescheck.view.base.BoosterFragment;
import com.booster.investortypescheck.view.base.FragmentFactory;
import com.booster.investortypescheck.view.base.FragmentType;
import com.booster.investortypescheck.view.base.InvestorTypeFactory;
import com.booster.investortypescheck.view.drawer.BoosterActionBarDrawerToggle;
import com.booster.investortypescheck.view.drawer.DrawerListAdapter;
import com.booster.investortypescheck.view.fragment.TypeFragment;

import static com.booster.investortypescheck.view.base.FragmentType.TYPE_PAGE;

public class MainActivity extends BaseFragmentActivity {
    private TypeFragment mTypeFragment;

    private ListView mDrawerList;
    private DrawerListAdapter mDrawerAdapter;
    private BoosterActionBarDrawerToggle mDrawerToggle;

    @Override
    public void initView(LayoutInflater inflater) {
        setContentView(R.layout.main_layout);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        mDrawerAdapter = new DrawerListAdapter(this);
        mDrawerList.setAdapter(mDrawerAdapter);

        mDrawerToggle = new BoosterActionBarDrawerToggle(this, mDrawerLayout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerList.setOnItemClickListener(new InvestorTypeClickListener());

    }

    @Override
    public void loadData() {

    }


    private void selectInvestorType(final int position, String type) {
        // update the main content by replacing fragments
        mTypeFragment = new InvestorTypeFactory().getFragment(type, this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(mTypeFragment!=null)
            fragmentManager.beginTransaction().replace(R.id.route_list_container, mTypeFragment).commit();
        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(findViewById(R.id.drawer));
    }


    private class InvestorTypeClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CharSequence optionName = ((TextView) view.findViewById(R.id.textView1)).getText();
            selectInvestorType(position, optionName.toString());
            Log.v("GXL", optionName.toString());
        }
    }

}
