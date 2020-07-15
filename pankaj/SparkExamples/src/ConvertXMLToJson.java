import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.transset.Trans;

public class ConvertXMLToJson {

	public static void main(String[] args) throws Exception {

		long st_time = System.currentTimeMillis();
		File file = new File("D:\\personal_dev\\tlogs\\Tlog\\B_M_49_1.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Trans.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Trans trns = (Trans) jaxbUnmarshaller.unmarshal(file);		
		
		long end_time = System.currentTimeMillis();
		System.out.println("Total time :" + (end_time - st_time));
		
		// Create simple transaction object from trans
		//Transaction tr = new Transaction();
		//PosID pid =  new PosID();
		//pid.setId(101);
		//tr.setPosID(pid);
		
		

		// Create a CodecRegistry containing the PojoCodecProvider instance.
		//CodecProvider pojoCodecProvider = PojoCodecProvider.builder().register("com.verifone.isd.vsms2.sales.ent.trans").build();
		//CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
		//		fromProviders(pojoCodecProvider));

		//MongoClient mongoClient = new MongoClient("localhost",
		//		MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("tlog");
		//MongoCollection<Transaction> collection = db.getCollection("T2", Transaction.class);
		//collection.insertOne(tr);
		
		// final JaxBsonContext jaxBsonContext = JaxBsonContext.newInstance(Trans.class);
		 //   final Document bson = jaxBsonContext.toBson(trns);
		   // System.out.println(bson.toJson());


//		Block<Trans> printBlock = new Block<Trans>() {
//			@Override
//			public void apply(final Trans trns) {
//				System.out.println(trns);
//			}
//		};
//
//		collection.find().forEach(printBlock);

		// MongoClient client = new MongoClient();
//		System.out.println(client);
//		
//		MongoDatabase db = client.getDatabase("test");
//		System.out.println(db);
//		Employee e = new Employee();
//		e.setNo(1);
//		e.setName("Pankaj");
//		String json = new Gson().toJson(e);
//		Document doc = Document.parse(json);
//		db.getCollection("Employee").insertOne(doc);
//	    // Retrieve to ensure object was inserted
//	    FindIterable<Document> iterable = db.getCollection("NameColl").find();
//	    iterable.forEach(new Block<Document>() {
//	      @Override
//	      public void apply(final Document document) {
//	        System.out.println(document); // See below to convert document back to Employee
//	      }
//	    });
		
		//mongoClient.close();
	}

}
