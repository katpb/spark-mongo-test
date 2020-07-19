package com.dashboard.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwt.charts.client.ChartLoader;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dashboard implements EntryPoint {

	private RootPanel root = RootPanel.get();
	private HTMLPanel dashBoard = new HTMLPanel("");
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		dashBoard.setStyleName("dashboard");

//		ByMopPieChart chart = new ByMopPieChart();
//		HTMLPanel hm = chart.getPanel();
	
		dashBoard.add(new ByMopPieChart().getPanel());
		dashBoard.add(new ByMopPieChart().getPanel());
		dashBoard.add(new ByMopPieChart().getPanel());
		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
//		
//		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
//		
//		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
//		
//		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
//		
//		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
//		
//		dashBoard.add(new ByMopPieChart().getPanel());
//		dashBoard.add(new ByMopBarChart().getPanel());
		RunChart.getInstance().run();
		root.add(dashBoard);
	}
}
