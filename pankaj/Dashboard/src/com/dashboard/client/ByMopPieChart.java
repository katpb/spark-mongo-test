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
import com.googlecode.gwt.charts.client.corechart.PieChart;

public class ByMopPieChart {
	PieChart mopChart;
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
		mopChart.clearChart();
		mopChart.draw(data);
		GWT.log("Done");
		flag = true;
		
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
		mopChart.clearChart();
		mopChart.draw(data);
		GWT.log("Done");
		flag = false;
		
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
				mopChart.clearChart();
				
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
						mainPanel.remove(mopChart);
						mopChart = new PieChart();
						mopChart.clearChart();
						if (flag) {
							drawPieChart2();
						} else {
							drawPieChart();
						}
						//mainPanel.clear();
						
						mainPanel.add(mopChart);
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
