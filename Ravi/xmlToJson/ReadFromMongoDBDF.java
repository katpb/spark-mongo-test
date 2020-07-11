package xmltojson;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SQLContext;

public class ReadFromMongoDBDF {
	public static void main(String args[]) {
		SparkSession session = SparkSession.builder().appName("dataFrame").master("local[*]").getOrCreate();
		session.sparkContext().setLogLevel("DEBUG");
		
	
		String monogdbHostName = "localhost";
		String monogdbPortNo = "27017";
		String mongodbUserName = "admin";
		String mongodbPassword = "admin";
		String mongodbDBName ="myDb";
		String monogdbCollectionName = "tlogSample2";
		
		String spark_mongoDB_output_uri = "mongodb://localhost:27017/myDb.tlogSample2";
		//Dataset<Row> usersDf = session.read().format("mongo").option("uri", spark_mongoDB_output_uri)
		//		.option("database", mongodbDBName).option("Collection", monogdbCollectionName).load();
		//usersDf.printSchema();
		Dataset<Row> sum = session.sql("SELECT sum(trans.trValue.trTotWTax) FROM tlogSample2 where trans.trHeader.trUniqueSN = 218175");
		sum.show();
		
		session.stop();
	}

	
}
