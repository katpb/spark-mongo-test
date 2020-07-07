package xmltojson;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RetrievingFromMongoDB {
	public static void main(String args[]) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("myDb");
		MongoCollection<Document> coll = db.getCollection("tlogss");
		Block<Document> printBlock = new Block<Document>() {
		            @Override
		            public void apply(final Document document) {
		                System.out.println(document.toJson());
		            }
		        };
		        
		
		//coll.find(new Document("name", new Document("$eq", "John"))).projection(new Document("_id", 0)).forEach(printBlock);
	}
}
