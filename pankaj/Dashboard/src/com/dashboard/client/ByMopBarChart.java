package com.dashboard.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.ComboChart;
import com.googlecode.gwt.charts.client.corechart.ComboChartOptions;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.SeriesType;
import com.googlecode.gwt.charts.client.options.VAxis;

public class ByMopBarChart {
	ComboChart mopChart;
	HTMLPanel mainPanel = new HTMLPanel("");
	
	public void drawMopBarChart() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
		chartLoader.loadApi(new Runnable() {
			public void run() {
				// Create and attach the chart
				mopChart = new ComboChart();
				mopChart.clearChart();
				
				drawPieChart();
				mainPanel.clear();
				mainPanel.add(mopChart);
			}

			private void drawPieChart() {
				// Prepare the data
				DataTable data = DataTable.create();
				data.addColumn(ColumnType.STRING, "Mop");
				data.addColumn(ColumnType.NUMBER, "Amount");
				
				data.addRow("Cash", 100);
				data.addRow("Credit", 200);
				data.addRow("Debit", 300);
				data.addRow("Cupon", 500);
				data.addRow("XYZ", 600);
				data.addRow("abc", 700);
				mopChart.clearChart();
				
				ComboChartOptions options = ComboChartOptions.create();
				options.setTitle("Credit card utilization");
				options.setHAxis(HAxis.create("Card Name"));
				options.setVAxis(VAxis.create("Total Amount"));
				options.setSeriesType(SeriesType.BARS);
				mopChart.draw(data, options);
				
			}
		});	
	}
	
	public HTMLPanel getPanel () {
		Button show = new Button("Show", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				drawMopBarChart();
				
			}
		});
		mainPanel.add(show);
		return mainPanel;
	}
	

}
