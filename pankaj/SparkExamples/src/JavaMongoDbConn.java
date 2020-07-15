import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JavaMongoDbConn {

	public static void main(String[] args) {
//		 MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
//		 System.out.println("Connected to the database successfully");  
//		  MongoDatabase database = mongo.getDatabase("test");  
//		 
//		  System.out.println(database.getCollection("test1").countDocuments());
//		  mongo.close();
		getDataFromDB();
	}
	
	
	private static void getDataFromDB() {
	
	Map <String, Double> resultMap = new HashMap<>(); 
	MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	System.out.println("Connected to the database successfully");  
	MongoDatabase database = mongo.getDatabase("txnDB");  
	MongoCollection<Document> resultDoc = database.getCollection("result"); 
	
	MongoCursor<Document> cursor = resultDoc.find().iterator();
	
	try {
	    while (cursor.hasNext()) {
	    	Document doc =  cursor.next();
	    	resultMap.put(String.valueOf(doc.get("mopcode")), Double.valueOf(String.valueOf(doc.get("total"))));
	    }
	} finally {
	    cursor.close();
	}
	
	 ObjectMapper objectMapper = new ObjectMapper();
	  try {
          String json = objectMapper.writeValueAsString(resultMap);
          System.out.println(json);
      } catch (JsonProcessingException e) {
          e.printStackTrace();
      }
	System.out.println(resultMap);
	
}

}
