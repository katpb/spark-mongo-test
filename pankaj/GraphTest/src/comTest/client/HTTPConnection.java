package comTest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class HTTPConnection {
	
	private static final String SERVLET_URL = "http://127.0.0.1:8080/go";	
	private static final HTTPConnection HTTP_CONN = new HTTPConnection();
	RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVLET_URL);
	private String respn;
	
	private HTTPConnection () {
	}

	public static final HTTPConnection getInstance () {
		return HTTP_CONN;
	}
	
	/**
	 * This API tries to make a Web-Servlet call until a valid response is received.
	 * Once the response is received, it tries to create a new Web socket
	 * connection.
	 */
	public void checkHTTPServlet() {

		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVLET_URL);

		try {
			GWT.log("Making servlet request - " + SERVLET_URL);

			requestBuilder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable t) {
					
				}

				public void onResponseReceived(Request request, Response resp) {

					// Finally when proper response is received.
						respn = resp.getText();
						GWT.log(respn);
				}				
			});

		} catch (RequestException e) {
			GWT.log("Could not send the request. " + e.getMessage(), e);
		}
	}
	
	public String getResult() {
		return respn;
		
	}
}
