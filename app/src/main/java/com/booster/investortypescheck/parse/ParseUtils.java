package com.booster.investortypescheck.parse;

import android.content.Context;
import android.util.Log;

import com.booster.investortypescheck.model.InvestorType;
import com.booster.investortypescheck.model.InvestorTypeBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ParseUtils {

    public static InvestorTypeBean mDefensiveBean = new InvestorTypeBean();
    public static InvestorTypeBean mConservativeBean = new InvestorTypeBean();
    public static InvestorTypeBean mBalancedBean = new InvestorTypeBean();
    public static InvestorTypeBean mBalancedGrowthBean = new InvestorTypeBean();
    public static InvestorTypeBean mGrowthBean = new InvestorTypeBean();
    public static InvestorTypeBean mAggressiveGrowthBean = new InvestorTypeBean();

    public static String getJsonString(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("investor_types_and_funds.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int result =is.read(buffer);
            is.close();
            if(result !=-1)
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.v("GXL",json);
        return json;
    }


    public static boolean parseJason(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            InvestorTypeBean typeBean;
            InvestorTypeBean.Mix mixBean;
            ArrayList<InvestorTypeBean.Mix> mixArrayList;

            JSONObject jsonObject;
            JSONObject mixArrayObject;

            for (int i = 0; i < jsonArray.length(); i++) {

                typeBean = new InvestorTypeBean();
                mixArrayList = new ArrayList<>();

                jsonObject = (JSONObject) jsonArray.get(i);
                String name = jsonObject.getString("name");
                String fundName = jsonObject.getString("fundName");
                String fundDetails = jsonObject.getString("fundDetails");

                JSONArray mixArray = jsonObject.getJSONArray("fundInvestmentMix");
                for (int j = 0; j < mixArray.length(); j++) {
                    mixArrayObject =  (JSONObject) mixArray.get(j);
                    mixBean = new InvestorTypeBean.Mix();
                    mixBean.setSectionTitle(mixArrayObject.getString("sectionTitle"));
                    mixBean.setAssetType(mixArrayObject.getString("assetType"));
                    mixBean.setPercentage(mixArrayObject.getInt("percentage"));
                    mixArrayList.add(mixBean);
                }
                typeBean.setName(name);
                typeBean.setFundName(fundName);
                typeBean.setFundDetails(fundDetails);
                typeBean.setFundInvestmentMix(mixArrayList);

                if(name.equals(InvestorType.DEFENSIVE.toString())) {
                    mDefensiveBean = typeBean;
                }else if(name.equals(InvestorType.CONSERVATIVE.toString())){
                    mConservativeBean =typeBean;
                } else if(name.equals(InvestorType.BALANCED.toString())){
                    mBalancedBean =typeBean;
                }else if(name.equals(InvestorType.BALANCE_GROWTH.toString())){
                    mBalancedGrowthBean =typeBean;
                }else if(name.equals(InvestorType.GROWTH.toString())){
                    mGrowthBean =typeBean;
                } else if(name.equals(InvestorType.AGGRESSIVE_GROWTH.toString())){
                    mAggressiveGrowthBean =typeBean;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
