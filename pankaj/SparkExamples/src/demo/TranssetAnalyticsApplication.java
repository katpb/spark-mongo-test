package demo;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;
import static org.apache.spark.sql.functions.substring;

import java.io.File;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.mongodb.spark.MongoSpark;

public class TranssetAnalyticsApplication {
	static {
		System.setProperty("hadoop.home.dir", "D:\\personal_dev\\spark\\hadoop");
	}
	
	public static void main(String[] args) {
		TranssetAnalyticsApplication app = new TranssetAnalyticsApplication();
		app.transform();
	}

	private void transform() {
		SparkSession session = SparkSession.builder()
			      .master("local")
			      .appName("TranssetAnalytics")
			      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
			      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.plus")
			      .getOrCreate();
		
		JavaSparkContext jsc = new JavaSparkContext(session.sparkContext());
		Dataset<Row> df = MongoSpark.load(jsc).toDF();
		Dataset<Row> trLines = df.select(substring(col("trans.trHeader.date"), 12, 5).as("trDateTime"), explode(col("trans.trLines.trLine")).as("trLine"));
		Dataset<Row> filteredPLUWithDate = trLines.filter(col("trLine.type").equalTo("plu")).select(col("trDateTime"), col("trLine.trlDesc").as("trPluDesc")).sort(col("trDateTime").asc());
		storeAsFile(filteredPLUWithDate, "filteredPLUWithDate");		
	}

	private void storeAsFile(Dataset<Row> df, String filepath) {
		File directory = new File(filepath);
		if(directory.exists()) {
			System.out.println("Directory exists. Attempting to delete it.");
			try {
				delete(directory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		df.javaRDD().repartition(1).saveAsTextFile(filepath);
	}

	private void delete(File file) {
		if(file.isDirectory()) {
			if(file.list().length==0){
				file.delete();
				System.out.println("Directory is deleted : "
						+ file.getAbsolutePath());
			}else{
				//list all the directory contents
				String files[] = file.list();
				for (String temp : files) {
					//construct the file structure
					File fileDelete = new File(file, temp);
					//recursive delete
					delete(fileDelete);
				}

				//check the directory again, if empty then delete it
				if(file.list().length==0){
					file.delete();
					System.out.println("Directory is deleted : "
							+ file.getAbsolutePath());
				}
			}
		} else {
    		//if file, then delete it
			file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
	}

}
