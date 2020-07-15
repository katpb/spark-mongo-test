package server;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Server {

	public static void main(String[] args) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("temp");
		tomcat.setPort(8080);

		String contextPath = "/";
		String docBase = new File(".").getAbsolutePath();

		Context context = tomcat.addContext(contextPath, docBase);

		HttpServlet servlet = new HttpServlet() {
			 @Override
	            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                    throws ServletException, IOException {
				 String dataset = req.getParameter("dataset");
				 resp.setHeader("Access-Control-Allow-Origin", "*");
				 String respoString; 
				 if (dataset.equals("mop")) {
					 respoString = getMopDet();
				 } else {
					 respoString = getCreditDet();
				 }
				 resp.getWriter().write(respoString);
			 }
			 
		};
		
		String servletName = "Servlet1";
        String urlPattern = "/go";
         
        tomcat.addServlet(contextPath, servletName, servlet);      
        context.addServletMappingDecoded(urlPattern, servletName);
         
        tomcat.start();
        tomcat.getServer().await();
	}
	
	private static String getMopDet () {
		String json = "";
		Map <String, Double> resultMap = new HashMap<>(); 
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Connected to the database successfully");  
		MongoDatabase database = mongo.getDatabase("txnDB");  
		MongoCollection<Document> resultDoc = database.getCollection("result"); 
		
		MongoCursor<Document> cursor = resultDoc.find().iterator();
		
		try {
		    while (cursor.hasNext()) {
		    	Document doc =  cursor.next();
		    	resultMap.put(String.valueOf(doc.get("mopcode")), Math.abs(Double.valueOf(String.valueOf(doc.get("total")))));
		    }
		} finally {
		    cursor.close();
		}
		
		 ObjectMapper objectMapper = new ObjectMapper();
		  try {
	          json = objectMapper.writeValueAsString(resultMap);
	    
	      } catch (JsonProcessingException e) {
	          e.printStackTrace();
	      }
		return json;
	}

	private static String getCreditDet () {
		String json = "";
		Map <String, Double> resultMap = new HashMap<>(); 
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Connected to the database successfully");  
		MongoDatabase database = mongo.getDatabase("txnDB");  
		MongoCollection<Document> resultDoc = database.getCollection("creditTrans"); 
		MongoCursor<Document> cursor = resultDoc.find().iterator();
		
		try {
		    while (cursor.hasNext()) {
		    	Document doc =  cursor.next();
		    	resultMap.put(String.valueOf(doc.get("value")), Math.abs(Double.valueOf(String.valueOf(doc.get("total")))));
		    }
		} finally {
		    cursor.close();
		}
		
		 ObjectMapper objectMapper = new ObjectMapper();
		  try {
	          json = objectMapper.writeValueAsString(resultMap);
	    
	      } catch (JsonProcessingException e) {
	          e.printStackTrace();
	      }
		return json;
	}
	
}
