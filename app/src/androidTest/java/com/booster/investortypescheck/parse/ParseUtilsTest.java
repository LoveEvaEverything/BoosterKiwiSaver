package com.booster.investortypescheck.parse;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.booster.investortypescheck.view.observer.LoginViewModel;

import org.junit.Assert;
import org.junit.Test;


public class ParseUtilsTest {
    Context context;
    @Test
    public void testParseUtilsTest() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String data = ParseUtils.getJsonString(context);
        Assert.assertNotNull(data);
    }

    @Test
    public void testParseUtilsTest02() {
//        new LoginViewModel(1).testCoroutineContext();
    }


    @Test
    public void testParseTest() {
        Assert.assertTrue(ParseUtils.parseJason(jason));
    }


    String jason = "[\n" +
            "    {\n" +
            "        \"name\":\"Defensive\",\n" +
            "        \"fundName\":\"Capital Guaranteed Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to provide relatively consistent returns, subject to a capital guarantee (see below).\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 1.5% above inflation over any two year period.\",\n" +
            "            \"Generally, there may be small movements up and down in the value of the fund.\",\n" +
            "            \"The fund invests mainly in income assets, and includes only a small amount of growth assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":60, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":10, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":5, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":10, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":15, \"assetType\":\"income\"}\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\":\"Conservative\",\n" +
            "        \"fundName\":\"Default Saver Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to provide relatively consistent but modest returns, with some capital gains over the longterm.\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 2.0% per year above inflation over any three year period.\",\n" +
            "            \"Generally, there will be small movements up and down in the value of the fund, reflecting its temporary holding nature.\",\n" +
            "            \"The fund invests mainly in income assets, but includes some growth assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":20, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":11, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":7, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":25, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":35, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"Listed property\", \"percentage\":2, \"assetType\":\"growth\"}\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\":\"Balanced\",\n" +
            "        \"fundName\":\"Balanced Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to provide an enhanced return over the long-term through capital gains.\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 3% per year above inflation over any five year period.\",\n" +
            "            \"There will be some movements up and down in the value of the fund.\",\n" +
            "            \"The fund invests in a more balanced mix of income assets and growth assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":2, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":30, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":18, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":26, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":17, \"assetType\":\"income\"}\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\":\"Balanced Growth\",\n" +
            "        \"fundName\":\"Balanced Growth Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to provide long-term capital gains but to partially offset short-term movements up and down with some income assets.\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 4% per year above inflation over any seven year period.\",\n" +
            "            \"There will be larger movements up and down in the value of the fund compared to the Balanced Fund.\",\n" +
            "            \"The fund invests mainly in growth assets, but includes some income assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":2, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":41, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":25, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":14, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":9, \"assetType\":\"income\"}\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\":\"Growth\",\n" +
            "        \"fundName\":\"High Growth Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to maximise the potential for capital gains over the long-term.\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 5% per year above inflation over any ten year period.\",\n" +
            "            \"There will be significant movements up and down in the value of the fund.\",\n" +
            "            \"The fund invests predominantly in growth assets, with little or no allocation to income assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":2, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":54, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":32, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":0, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":0, \"assetType\":\"income\"}\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\":\"Aggressive Growth\",\n" +
            "        \"fundName\":\"High Growth Fund\",\n" +
            "        \"fundDetails\":[\n" +
            "            \"The fund’s objective is to maximise the potential for capital gains over the long-term.\",\n" +
            "            \"It aims to achieve returns (after fees but before tax) of at least 5% per year above inflation over any ten year period.\",\n" +
            "            \"There will be significant movements up and down in the value of the fund.\",\n" +
            "            \"The fund invests predominantly in growth assets, with little or no allocation to income assets.\"\n" +
            "        ],\n" +
            "        \"fundInvestmentMix\":[\n" +
            "            {\"sectionTitle\":\"Cash and cash equivalents\", \"percentage\":2, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"International equities\", \"percentage\":54, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"Australasian equities\", \"percentage\":32, \"assetType\":\"growth\"},\n" +
            "            {\"sectionTitle\":\"International fixed interest\", \"percentage\":0, \"assetType\":\"income\"},\n" +
            "            {\"sectionTitle\":\"New Zealand fixed interest\", \"percentage\":0, \"assetType\":\"income\"}\n" +
            "        ]\n" +
            "    }\n" +
            "]\n";
}