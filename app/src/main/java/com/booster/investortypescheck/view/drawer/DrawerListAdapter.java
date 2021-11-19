package com.booster.investortypescheck.view.drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.booster.investortypescheck.model.InvestorType;
import com.booster.investortypescheck.R;

import java.util.ArrayList;

public class DrawerListAdapter extends BaseAdapter {

    public ArrayList<View> views;

//    Defensive, Conservative, Balanced, Balanced Growth, Growth and Aggressive Growth
    public DrawerListAdapter(Context con) {
        views = getViewsList(con);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    public ArrayList<View> getViewsList(Context con) {
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<View> viewList = new ArrayList<>();
        for(InvestorType item : InvestorType.values()) {
            viewList = addMenuText(inflater, viewList, item.toString());
        }
        return viewList;
    }


    private ArrayList<View> addMenuText(LayoutInflater inflater, ArrayList<View> viewList, String text) {
		@SuppressLint("InflateParams")
        View v = inflater.inflate(R.layout.drawer_list_title, null);
		TextView vehicleAudit = ((TextView) v.findViewById(R.id.textView1));
        vehicleAudit.setText(text);
        viewList.add(v);
        return viewList;
    }

    @Override
    public Object getItem(int position) {
        return views.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return views.get(position);
    }

}
