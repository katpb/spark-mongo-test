package demo;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.mongodb.spark.MongoSpark;

public class TlogAnalysis {
	static {
		System.setProperty("hadoop.home.dir", "D:\\personal_dev\\spark\\hadoop");
	}
	public static void main(String[] args) {
		SparkSession sparkSession = SparkSession.builder().master("local").appName("MongoSparkConnectorTest")
				.config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
				.config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.creditTrans")
				.getOrCreate();

		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
		
		Dataset<Row> trPayLines = implicitDS.select(col("trans.trHeader.trUniqueSN").as("trnum"), col("trans.type").as("type"), col("trans.trHeader.trTickNum.trSeq").as("seqnum"),
				(explode(col("trans.trPaylines.trPayline")).as("trPaylines")));
		trPayLines.createOrReplaceTempView("paymentlines");
		trPayLines.printSchema();
		
		trPayLines.show();

		getByMop(sparkSession);
		getByCreditCard(sparkSession);
		//getDeptDet(implicitDS, sparkSession);
		
	}
	
	public static void getByMop(SparkSession sparkSession) {
		// By Mop
		System.out.println("+++++++++++++By MOP+++++++++++++++++++++++++++");
		Dataset<Row> mopCount = sparkSession.sql(
				"SELECT sum(trPaylines.trpAmt) as total , trPaylines.trpPaycode.value as mopcode, count(trPaylines.trpPaycode.value) as numMopCode FROM paymentlines group by trPaylines.trpPaycode.value");
		mopCount.show();
		mopCount.printSchema();

		// WriteConfig writeConfig = WriteConfig.create(jsc);
		// MongoSpark.save(creditCount, writeConfig);
		
		System.out.println("==================================================");

	}

	public static void getByCreditCard(SparkSession sparkSession) {
		// Get credit card name type transaction
		System.out.println("+++++++++++++Credit details+++++++++++++++++++++++++++");
		Dataset<Row> creditCount = sparkSession.sql(
				"SELECT trPaylines.trpCardInfo.trpcCCName.value as value, count(trPaylines.trpCardInfo.trpcCCName.value) as count, sum(trPaylines.trpAmt) as total FROM paymentlines where type=\"network sale\" and trPaylines.trpCardInfo.trpcCCName.value != \"null\" group by trPaylines.trpCardInfo.trpcCCName.value");

		creditCount.show();
		creditCount.printSchema();
		// WriteConfig writeConfig = WriteConfig.create(jsc);
		// MongoSpark.save(creditCount, writeConfig);
		System.out.println("==========================================================");
	}
	
	public static void getDeptDet(Dataset<Row> implicitDS, SparkSession sparkSession){
		Dataset<Row>trLines = implicitDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"),explode(col("trans.trLines.trLine")).as("trLines")); 	
		  trLines.createOrReplaceTempView("itemlines");		  
		Dataset<Row> trlDept = sparkSession
				.sql("SELECT COUNT(trLines.trlDept), trLines.trlDept.value FROM itemLines GROUP BY trLines.trlDept");
		trlDept.show();
		trlDept.printSchema();
	}	
	
	
}