package xmltojson;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

public final class ReadFromMongoDB {

	public static void main(final String[] args) throws InterruptedException {

		//SparkSession spark = SparkSession.builder().master("local").appName("MongoSparkConnectorIntro")
		//		.config("spark.mongodb.input.uri", "mongodb://localhost:27017/test.test1").getOrCreate();

		SparkConf sparkConf = new SparkConf();

		sparkConf.setAppName("MongoSparkConnectorIntro");
		sparkConf.setMaster("local");
		sparkConf.set("spark.mongodb.input.uri", "mongodb://localhost:27017/myDb.tlogSample2");
		sparkConf.set("spark.mongodb.output.uri", "mongodb://localhost:27017/test.tlogs");

		JavaSparkContext jsc = new JavaSparkContext(sparkConf);

		JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

		System.out.println("count : "+rdd.count());
		//System.out.println(rdd.first().toJson());
		jsc.close();

	}

}