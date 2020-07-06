package com.verifone.ptc;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

public final class MongoDBReaderAndWriter {

	public static void main(final String[] args) throws InterruptedException {
		
	//System.setProperty("hadoop.home.dir", "C:\\Users\\satish_r1\\Spark\\hadoop");

	SparkSession sparkSession = SparkSession.builder()
			      .master("local")
			      .appName("MongoSparkConnectorTest")
			      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/student.allStudents")
			      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/student.studentC")
			      .getOrCreate();
		
		
		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

		JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);
		
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
	    implicitDS.printSchema();
	    implicitDS.show();
		
	    implicitDS.createOrReplaceTempView("allStudents");
	    Dataset<Row> b_section_students = sparkSession.sql("SELECT student_id, class, section FROM allStudents WHERE section == \"B\"");
		//MongoSpark.save(rdd.)
	    b_section_students.show();
	    MongoSpark.write(b_section_students).option("student", "studentC").mode("overwrite").save();
	    
		System.out.println(rdd.count());
		for(int i=0; i < rdd.count();i++) {
			System.out.println("StudentID" +rdd.collect().get(i).get("student_id"));
		}
		//while(rdd.collect().)
		System.out.println(rdd.first().toJson());
		jsc.close();

	}

}