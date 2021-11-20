package com.booster.investortypescheck.model;

import com.anychart.charts.Pie;

import java.util.ArrayList;

public class InvestorTypeBean {

    String name,fundName,fundDetails;
    ArrayList<Mix>  fundInvestmentMix;
    ArrayList<String> funDetailsList;

    public ArrayList<String> getFunDetailsList() {
        return funDetailsList;
    }

    public void setFunDetailsList(ArrayList<String> funDetailsList) {
        this.funDetailsList = funDetailsList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundDetails() {
        return fundDetails;
    }

    public void setFundDetails(String fundDetails) {
        this.fundDetails = fundDetails;
    }

    public ArrayList<Mix> getFundInvestmentMix() {
        return fundInvestmentMix;
    }

    public void setFundInvestmentMix(ArrayList<Mix> fundInvestmentMix) {
        this.fundInvestmentMix = fundInvestmentMix;
    }





    public static class Mix{
        String sectionTitle;

        public String getSectionTitle() {
            return sectionTitle;
        }

        public void setSectionTitle(String sectionTitle) {
            this.sectionTitle = sectionTitle;
        }

        public int getPercentage() {
            return percentage;
        }

        public void setPercentage(int percentage) {
            this.percentage = percentage;
        }

        public String getAssetType() {
            return assetType;
        }

        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }

        int percentage;
        String assetType;
    }


}
