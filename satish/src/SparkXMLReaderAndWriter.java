import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkXMLReaderAndWriter {

	public static void main(String[] args) {
		
		System.setProperty("hadoop.home.dir", "C:\\Users\\satish_r1\\Spark\\hadoop");

		SparkSession sparkSession = SparkSession.builder()
			      .master("local")
			      .appName("SparkXMLTest").getOrCreate();
		Dataset<Row> transactions = sparkSession.read().format("xml").option("rootTag","transSet").option("rowTag", "trans").load("2-2018-11-28.133.xml");
		//transactions.flatMap(f, encoder)
		transactions.show();
		System.out.println(transactions.first());
		transactions.write().format("json");

	}

}
