import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class JavaMongoDBClient {

	public static void main(String[] args) {
		 MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		 System.out.println("Connected to the database successfully");  
		 MongoDatabase database = mongo.getDatabase("student");  		 
		 System.out.println(database.getCollection("studentA").countDocuments());
		 System.out.println(database.getCollection("allStudents").countDocuments());
		 mongo.close();
	}

}
