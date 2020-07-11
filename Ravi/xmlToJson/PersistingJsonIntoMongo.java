package xmltojson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bson.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PersistingJsonIntoMongo {
	public static void main(String args[]) {

		XmlMapper xmlMapper = new XmlMapper();
		JsonNode node;
		try {
			
			File directory = new File("/Users/rsshivakrishnam/Desktop/SparkAnalyticsOnMongoDB/src/dataFiles/tlogs");
			File[] listOfFiles = directory.listFiles();
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = mongoClient.getDatabase("myDb");
            
			for (File file : listOfFiles) {
				node = xmlMapper.readTree(new FileInputStream(file));			
				ObjectMapper jsonMapper = new ObjectMapper();
				String json = jsonMapper.writeValueAsString(node);
	            MongoCollection<Document> collection = db.getCollection("tlogSample2");
	            Document doc = Document.parse(json);
	            collection.insertOne(doc);
			}
			
            System.out.println("Insertion is Done");
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
