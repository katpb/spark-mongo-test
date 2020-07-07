package xmltojson;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bson.Document;
//import org.joda.time.chrono.AssembledChronology.Fields;
//import org.json.XML;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Main2 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		//Method 1 using Jackson
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode node = xmlMapper.readTree(new File("XML.xml"));
		ObjectMapper jsonMapper = new ObjectMapper();
		String json = jsonMapper.writeValueAsString(node);
		BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
		writer.write(json);
		writer.close();
		Document doc1 = Document.parse(json);
		MongoClient mc = MongoClients.create();
		MongoDatabase db = mc.getDatabase("testdb");
		MongoCollection<Document> coll = db.getCollection("employees");
		coll.insertOne(doc1);
		
		//Method 2 using org.json
//		String json2 = XML.toJSONObject(new FileReader("XML.xml")).toString();
//		BufferedWriter writer2 = new BufferedWriter(new FileWriter("out2.txt"));
//		writer2.write(json2);
//		writer2.close();
//		Document doc2 = Document.parse(json2);
//		//coll.insertOne(doc2);
//		Block<Document> printBlock = new Block<Document>() {
//			@Override
//			public void apply(final Document document) {
//				System.out.println(document.toJson());
//			}
//		};
		//coll.find().forEach(printBlock);
		//coll.find(new Document("name", new Document("$eq", "John"))).projection(new Document("_id", 0)).forEach(printBlock);
//		coll.find(new Document("pd:summaryPd.vs:period.periodType", new Document("$eq", "daypart"))).projection(new Document("pd:summaryPd.vs:period.periodType", 1).append("_id", 0)).forEach(printBlock);
//		coll.find(new Document("pd:summaryPd.totals.totalizers.start.insideGrand", new Document("$gte", 150.0))).projection(new Document("pd:summaryPd.totals.totalizers.start.insideGrand", 1).append("_id", 0)).forEach(printBlock);
		System.out.println("done!");
	}

}
