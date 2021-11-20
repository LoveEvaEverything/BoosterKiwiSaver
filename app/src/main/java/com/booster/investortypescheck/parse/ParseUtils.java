package com.booster.investortypescheck.parse;

import android.content.Context;
import android.util.Log;

import com.anychart.AnyChart;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.booster.investortypescheck.model.InvestorType;
import com.booster.investortypescheck.model.InvestorTypeBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseUtils {

    public static Map<InvestorType, InvestorTypeBean> typeBeanMap;

    public static InvestorTypeBean mDefensiveBean ;
    public static InvestorTypeBean mConservativeBean;
    public static InvestorTypeBean mBalancedBean;
    public static InvestorTypeBean mBalancedGrowthBean;
    public static InvestorTypeBean mGrowthBean;
    public static InvestorTypeBean mAggressiveGrowthBean;



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
            ArrayList<String> detailsList;

            JSONObject jsonObject;
            JSONObject mixArrayObject;
            for (int i = 0; i < jsonArray.length(); i++) {

                typeBean = new InvestorTypeBean();
                mixArrayList = new ArrayList<>();
                detailsList = new ArrayList<>();
                jsonObject = (JSONObject) jsonArray.get(i);
                String name = jsonObject.getString("name");
                String fundName = jsonObject.getString("fundName");
                JSONArray detailsArray = jsonObject.getJSONArray("fundDetails");
                for (int d = 0; d < detailsArray.length(); d++){
                    detailsList.add((String)detailsArray.get(d));
                }

                typeBean.setFunDetailsList(detailsList);


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
//                typeBean.setFundDetails(fundDetails);
                typeBean.setFundInvestmentMix(mixArrayList);

                if(name.equals(InvestorType.DEFENSIVE.toString())) {
                    mDefensiveBean = typeBean;
//                    mDefensiveBean.setPie(getPieChart(mDefensiveBean));
                }else if(name.equals(InvestorType.CONSERVATIVE.toString())){
                    mConservativeBean =typeBean;
//                    mConservativeBean.setPie(getPieChart(mConservativeBean));
                } else if(name.equals(InvestorType.BALANCED.toString())){
                    mBalancedBean =typeBean;
//                    mBalancedBean.setPie(getPieChart(mBalancedBean));
                }else if(name.equals(InvestorType.BALANCE_GROWTH.toString())){
                    mBalancedGrowthBean =typeBean;
//                    mBalancedGrowthBean.setPie(getPieChart(mBalancedGrowthBean));
                }else if(name.equals(InvestorType.GROWTH.toString())){
                    mGrowthBean =typeBean;
//                    mGrowthBean.setPie(getPieChart(mGrowthBean));
                } else if(name.equals(InvestorType.AGGRESSIVE_GROWTH.toString())){
                    mAggressiveGrowthBean =typeBean;
//                    mAggressiveGrowthBean.setPie(getPieChart(mAggressiveGrowthBean));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        Log.v("GXL", "loading finished");
        return true;
    }



    public static Pie getPieChart(InvestorTypeBean investorTypeBean) {
        Pie pie = AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        for (InvestorTypeBean.Mix item: investorTypeBean.getFundInvestmentMix()) {
            data.add(new ValueDataEntry(item.getSectionTitle(), item.getPercentage()));
        }
        pie.data(data);
        pie.labels().position("outside");
        pie.legend().title().enabled(true);
        pie.legend().title().align(Align.LEFT);
        pie.legend().title().text("Target investment mix").padding(0d, 0d, 10d, 0d);
        pie.legend().position("center-bottom").itemsLayout(LegendLayout.HORIZONTAL).align(Align.CENTER);
        return pie;
    }
}
