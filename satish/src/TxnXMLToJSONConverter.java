import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class TxnXMLToJSONConverter {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String TEST_XML_STRING = null;

	public static void main(String[] args) throws IOException {
		File tlogDir = new File("CadenceTransactions");
		if(tlogDir.isDirectory()) {
			for (int i = 0; i < 10; i++) {
				for (String fileName : tlogDir.list()) {
					File file = new File(tlogDir.getName() + "/" + fileName);
					FileInputStream fin = new FileInputStream(file);
					byte[] xmlData = new byte[(int) file.length()];
					fin.read(xmlData);
					fin.close();
					TEST_XML_STRING = new String(xmlData, "UTF-8");

					try {
						JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
						String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
						System.out.println(jsonPrettyPrintString);
						new TxnXMLToJSONConverter().writeToDB(jsonPrettyPrintString);
					} catch (JSONException e) {
						System.out.println(e.toString());
					}

				} 
			}
		}
	}
		
	public void writeToDB(String json) {
		Document doc = Document.parse(json);
		MongoClient mongo = new MongoClient("localhost", 27017);
		System.out.println("Connected to the database successfully");		
		MongoDatabase database = mongo.getDatabase("txnDB");
		System.out.println(database.getCollection("transactions").countDocuments());
		database.getCollection("transactions").insertOne(doc);
		System.out.println(database.getCollection("transactions").countDocuments());
		mongo.close();
	}
}
