package com.booster.investortypescheck.view.fragment;

import android.view.LayoutInflater;
import android.widget.LinearLayout;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.booster.investortypescheck.R;
import com.booster.investortypescheck.model.InvestorTypeBean;
import com.booster.investortypescheck.parse.ParseUtils;
import com.booster.investortypescheck.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TypeFragment extends BaseFragment {


    InvestorTypeBean investorTypeBean;
    AnyChartView anyChartView;
    LinearLayout detailsLayout;

    public TypeFragment(InvestorTypeBean investorTypeBean) {
        this.investorTypeBean = investorTypeBean;
    }


    @Override
    public void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.type_layout,null);

        anyChartView = rootView.findViewById(R.id.any_chart_view);
        detailsLayout = rootView.findViewById(R.id.fund_details_id);
        anyChartView.setProgressBar(rootView.findViewById(R.id.progress_bar));
    }

    @Override
    public void loadData() {
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
        anyChartView.setChart(pie);
    }
}
