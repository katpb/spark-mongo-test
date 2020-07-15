import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.mongodb.spark.MongoSpark;

public class FuelSales {
	static {
		System.setProperty("hadoop.home.dir", "D:\\personal_dev\\spark\\hadoop");
	}
	public static void main(String[] args) {
		SparkSession sparkSession = SparkSession.builder().master("local").appName("MongoSparkConnectorTest")
				.config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
				.config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.fuelsales")
				.getOrCreate();

		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
		
		Dataset<Row> trPayLines = implicitDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type").as("type"),
				(explode(col("trans.trPaylines.trPayline")).as("trPaylines")));
		trPayLines.createOrReplaceTempView("paymentlines");
		trPayLines.show();
		trPayLines.printSchema();
		//Dataset<Row> creditCount = sparkSession
		//		.sql("SELECT trPaylines.trpPaycode.value as mopcode,count(trPaylines), sum(trPaylines.trpAmt) FROM paymentlines where trPaylines.trpPaycode.value = \"CASH\"");
		//creditCount.show();
		Dataset<Row> creditCount = sparkSession
				//.sql("SELECT sum(trPaylines.trpAmt) FROM paymentlines where trPaylines.trpPaycode.value = \"CASH\" and trPaylines.type = \"sale\"");
				.sql("SELECT sum(trPaylines.trpAmt) as total , trPaylines.trpPaycode.value as mopcode, count(trPaylines.trpPaycode.value) as numMopCode FROM paymentlines group by trPaylines.trpPaycode.value");
		creditCount.show();
		//WriteConfig writeConfig = WriteConfig.create(jsc);
		//MongoSpark.save(creditCount, writeConfig);
		
	}

}
