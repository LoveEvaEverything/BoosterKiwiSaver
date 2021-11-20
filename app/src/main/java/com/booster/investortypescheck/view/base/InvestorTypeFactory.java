package com.booster.investortypescheck.view.base;


import android.content.Context;

import com.booster.investortypescheck.model.InvestorType;
import com.booster.investortypescheck.parse.ParseUtils;
import com.booster.investortypescheck.view.fragment.TypeFragment;

import static com.booster.investortypescheck.parse.ParseUtils.parseJason;
import static com.booster.investortypescheck.view.base.FragmentType.INTRODUCTION_PAGE;
import static com.booster.investortypescheck.view.base.FragmentType.QUESTION_PAGE;

public class InvestorTypeFactory {

    public TypeFragment getFragment(String type, Context context){
        if(type == null){
            return null;
        }

        if(type.equals(InvestorType.DEFENSIVE.toString())){
            if(ParseUtils.mDefensiveBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mDefensiveBean);
        } else if(type.equals(InvestorType.CONSERVATIVE.toString())){
            if(ParseUtils.mConservativeBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mConservativeBean);
        }else if(type.equals(InvestorType.BALANCED.toString())){
            if(ParseUtils.mBalancedBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mBalancedBean);
        }else if(type.equals(InvestorType.BALANCE_GROWTH.toString())){
            if(ParseUtils.mBalancedGrowthBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mBalancedGrowthBean);
        }else if(type.equals(InvestorType.GROWTH.toString())){
            if(ParseUtils.mGrowthBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mGrowthBean);
        } else if(type.equals(InvestorType.AGGRESSIVE_GROWTH.toString())){
            if(ParseUtils.mAggressiveGrowthBean == null)
                parseJason(ParseUtils.getJsonString(context));
            return new TypeFragment(ParseUtils.mAggressiveGrowthBean);
        }
        return null;
    }
}
