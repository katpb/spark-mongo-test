package com.verifone.ptc;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.bson.Document;
import org.json.JSONException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.transset.Trans;

public class TxnXMLToJSONConverterJAXB {



	public static void main(String[] args) throws IOException {
		File tlogDir = new File("CadenceTransactions");
		if(tlogDir.isDirectory()) {
			for (int i = 0; i < 1; i++) {
				for (String fileName : tlogDir.list()) {
					File file = new File(tlogDir.getName() + "/" + fileName);
//					FileInputStream fin = new FileInputStream(file);
//					byte[] xmlData = new byte[(int) file.length()];
//					fin.read(xmlData);
//					fin.close();
//					TEST_XML_STRING = new String(xmlData, "UTF-8");
					
					Trans trans = unmarshall(file);
					try {
//						JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
//						String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
						System.out.println(marshall(trans));
						writeToDB(marshall(trans));
					} catch (JSONException e) {
						System.out.println(e.toString());
					}

				} 
			}
		}
	}
		
	public static void writeToDB(String json) {
		Document doc = Document.parse(json);
		MongoClient mongo = new MongoClient("localhost", 27017);
		System.out.println("Connected to the database successfully");		
		MongoDatabase database = mongo.getDatabase("txnDB");
		System.out.println(database.getCollection("transactions").countDocuments());
		database.getCollection("transactions").insertOne(doc);
		System.out.println(database.getCollection("transactions").countDocuments());
		mongo.close();
	}
	
	
    public static Trans unmarshall(File file) {
    	 Trans trans = null;
    	try {
    	JAXBContext jc = JAXBContext.newInstance("com.transset", Trans.class.getClassLoader());
    	 
        // Create the Unmarshaller Object using the JaxB Context
        Unmarshaller unmarshaller = jc.createUnmarshaller();
 
        // Set the Unmarshaller media type to JSON or XML
//        unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,
//                "application/xml");
        trans = (Trans) unmarshaller.unmarshal(file);
        System.out.println("Unmarshalled object" + trans);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return trans;
    }
	
	public static String marshall(Trans trans) {
//		Map<String, Object> properties = new HashMap<String, Object>(2);
//		properties.put("eclipselink.media-type", "application/json");
		StringWriter stringWriter = new StringWriter();
		try {
			// Create a JaxBContext
			JAXBContext jc = JAXBContext.newInstance(Trans.class);

			// Create the Marshaller Object using the JaxB Context
			Marshaller marshaller = jc.createMarshaller();

			// Set the Marshaller media type to JSON or XML
			 marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,
		                "application/json");
				// Set it to true if you need to include the JSON root element in the JSON output
			marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

			// Set it to true if you need the JSON output to formatted
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		
			marshaller.marshal(trans, stringWriter);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stringWriter.toString();
	}
		
}

