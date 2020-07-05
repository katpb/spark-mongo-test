
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import static org.apache.spark.sql.functions.col;

public final class TxnDBReaderAndWriter {

	public static void main(final String[] args) throws InterruptedException {
		
	//System.setProperty("hadoop.home.dir", "C:\\Users\\satish_r1\\Spark\\hadoop");

	SparkSession sparkSession = SparkSession.builder()
			      .master("local")
			      .appName("MongoSparkConnectorTest")
			      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
			      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.plus")
			      .getOrCreate();
		
		
		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

		JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);
		
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
	    implicitDS.printSchema();
	    implicitDS.show();
	    
	    implicitDS.select("trans.trHeader.trUniqueSN").show();
	    
	    
	    implicitDS.filter(col("trans.trValue.trTotWTax").between("0.01", "2.00")).select("trans.trHeader.trUniqueSN").show();
		
	    implicitDS.createOrReplaceTempView("transactions");
	    Dataset<Row> sum = sparkSession.sql("SELECT sum(trans.trValue.trTotWTax) FROM transactions where trans.trHeader.trUniqueSN = 218175");
	  //  Dataset<Row> trGt5 = sparkSession.sql("SELECT trans.trHeader.trUniqueSN FROM transactions where trans.trValue.trTotWTax=  5.00");

		//MongoSpark.save(rdd.)
	    sum.show();
//	    MongoSpark.write(transactions).option("student", "studentC").mode("overwrite").save();
	    
//		System.out.println(rdd.count());
//		for(int i=0; i < rdd.count();i++) {
//			System.out.println("StudentID" +rdd.collect().get(i).get("student_id"));
//		}
//		//while(rdd.collect().)
//		System.out.println(rdd.first().toJson());
//		jsc.close();

	}

}