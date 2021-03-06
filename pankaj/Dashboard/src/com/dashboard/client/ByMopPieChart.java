package com.dashboard.client;

import com.google.gwt.core.client.GWT;
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
import com.googlecode.gwt.charts.client.corechart.PieChart;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.SeriesType;
import com.googlecode.gwt.charts.client.options.VAxis;

public class ByMopPieChart {
	PieChart mopChart;
	ComboChart barChart;
	HTMLPanel mainPanel = new HTMLPanel("");
	boolean flag;
	
	public void drawMopPieChart() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
		chartLoader.loadApi(new Runnable() {
			public void run() {
				// Create and attach the chart
				mopChart = new PieChart();
				mopChart.clearChart();
				
				drawPieChart();
				//mainPanel.clear();
				mainPanel.add(mopChart);
			}

		});	
		
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
		mopChart.draw(data);
		GWT.log("Done");
		flag = false;
		
	}
	
	private void drawPieChart2() {
		// Prepare the data
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Mop");
		data.addColumn(ColumnType.NUMBER, "Amount");
		
		data.addRow("Cash", 100);
		data.addRow("Credit", 200);
		data.addRow("Debit", 300);
		data.addRow("Cupon", 500);
		
		ComboChartOptions options = ComboChartOptions.create();
		options.setTitle("Credit card utilization");
		options.setHAxis(HAxis.create("Card Name"));
		options.setVAxis(VAxis.create("Total Amount"));
		options.setSeriesType(SeriesType.BARS);
		barChart.draw(data, options);
		GWT.log("Done");
		flag = true;
		
	}
	
	public HTMLPanel getPanel () {
//		Button show = new Button("Show", new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				drawMopPieChart();
//				
//			}
//		});
//		mainPanel.add(show);
		ChartObject obj = new ChartObject();
		obj.setCorechart(ChartPackage.CORECHART);
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
				// Create and attach the chart
				mopChart = new PieChart();				
				drawPieChart();
				//mainPanel.clear();
				mainPanel.add(mopChart);
				RunChart.getInstance().notifyDone();
				
			}
		};
		obj.setRunnable(runnable);
		RunChart.getInstance().getChartList().add(obj);
		
		Button b = new Button("Show other view ", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Runnable run = new Runnable() {
					
					@Override
					public void run() {
						// Create and attach the chart
						if (mopChart != null) {
							mopChart.clearChart();
							mainPanel.remove(mopChart);
							GWT.log("Remove pie chart");
						} 
						if (barChart != null) {
							barChart.clearChart();
							mainPanel.remove(barChart);
						}
						if (flag) {
						
							mopChart = new PieChart();
							
							drawPieChart();
							mainPanel.add(mopChart);
						} else {
							barChart = new ComboChart();
							drawPieChart2();
							mainPanel.add(barChart);
						}
						
						RunChart.getInstance().notifyDone();	
					}
						
				};
				obj.setCorechart(ChartPackage.CORECHART);
				obj.setRunnable(run);
				RunChart.getInstance().getChartList().add(obj);
				RunChart.getInstance().run();
			}
		} );
		mainPanel.add(b);
		return mainPanel;
	}
	
	

}
