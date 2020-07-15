package comTest.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
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

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GraphTest implements EntryPoint {
	private static final String SERVLET_URL = "http://127.0.0.1:8080/go";
	Map<String, Double> map = new HashMap<String, Double>();
	private ComboChart chart;
	private PieChart pieChart;
	private RootPanel root = RootPanel.get();
	private HTMLPanel hm = new HTMLPanel("");
	
	private void initializeMop() {	
		ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
		chartLoader.loadApi(new Runnable() {
			public void run() {
				// Create and attach the chart
				pieChart = new PieChart();
				pieChart.clearChart();
				drawPieChart();
				hm.clear();
				hm.add(pieChart);
			}
		});		
	}

	private void initializeCredit() {
	
		ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
		chartLoader.loadApi(new Runnable() {
			public void run() {
				// Create and attach the chart
				chart = new ComboChart();				
				drawBar();
				hm.clear();
				hm.add(chart);
			}
		});
				
	}

	
	private void drawPieChart() {
		// Prepare the data
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Mop");
		data.addColumn(ColumnType.NUMBER, "Amount");
		
		for (String key : map.keySet()) {
			GWT.log("Key " + key + ":" + map.get(key));
			data.addRow(key, map.get(key));
		}
		
	  	pieChart.clearChart();
	    pieChart.draw(data);
	    pieChart.setHeight("800px");	    
	    pieChart.setWidth("800px");
	
	}

	private void drawBar() {
		// Prepare the data
		DataTable data1 = DataTable.create();
		
		data1.addColumn(ColumnType.STRING, "Cards");
		data1.addColumn(ColumnType.NUMBER, "Amount");

		for (String key : map.keySet()) {
			GWT.log("Key " + key + ":" + map.get(key));
			data1.addRow(key, map.get(key));
		}
		// Set options
		ComboChartOptions options = ComboChartOptions.create();
		options.setTitle("Credit card utilization");
		options.setHAxis(HAxis.create("Card Name"));
		options.setVAxis(VAxis.create("Total Amount"));
		options.setSeriesType(SeriesType.BARS);

		// Draw the chart

		chart.draw(data1, options);
		//chart.setWidth("800px");
		chart.setHeight("800px");

	}

	
	public void onModuleLoad() {
		Button byMop = new Button("By Mop", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				loadMopDet();

			}
		});

		Button byCreditCard = new Button("By Credit Card", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				loadCreditCardDet();

			}			
		});
		root.add(byMop);
		root.add(byCreditCard);
		//loadCreditCardDet();
		//loadMopDet();
		hm.setHeight("100%");
		hm.setWidth("100%");
		root.add(hm);
	}

	private void loadMopDet() {
		// send Request
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVLET_URL + "?dataset=mop");

		try {
			GWT.log("Making servlet request - " + SERVLET_URL );

			requestBuilder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable t) {

				}

				public void onResponseReceived(Request request, Response resp) {

					// Finally when proper response is received.
					String res = resp.getText();
					GWT.log(res);

					JSONValue jsonValue = JSONParser.parseStrict(res);
					GWT.log(jsonValue.toString());

					JSONObject jsonObj = jsonValue.isObject();
					GWT.log("Json obj" + jsonObj.toString());
					map.clear();
					for (String key : jsonObj.keySet()) {
						GWT.log("Key : " + key + " = " + jsonObj.get(key).toString());
						map.put(key, Double.parseDouble(jsonObj.get(key).toString()));
					}

					// JSONArray jsonArray = jsonObj.isArray();
//								GWT.log(jsonArray.toString());
//								GWT.log("" + jsonArray.size());
				}
			});
			initializeMop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadCreditCardDet() {
		// send Request
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVLET_URL + "?dataset=credit");

		try {
			GWT.log("Making servlet request - " + SERVLET_URL);

			requestBuilder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable t) {

				}

				public void onResponseReceived(Request request, Response resp) {

					// Finally when proper response is received.
					String res = resp.getText();
					GWT.log(res);

					JSONValue jsonValue = JSONParser.parseStrict(res);
					GWT.log(jsonValue.toString());

					JSONObject jsonObj = jsonValue.isObject();
					GWT.log("Json obj" + jsonObj.toString());
					map.clear();
					for (String key : jsonObj.keySet()) {
						GWT.log("Key : " + key + " = " + jsonObj.get(key).toString());
						map.put(key, Double.parseDouble(jsonObj.get(key).toString()));
					}
				}
			});
			initializeCredit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
