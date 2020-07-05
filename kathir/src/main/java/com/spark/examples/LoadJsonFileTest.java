package com.spark.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class LoadJsonFileTest {
	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().master("local").appName("Loading JSON Test").getOrCreate();
		Dataset<Row> json = spark.read().json("example_1.json").cache();
		json.count();
	}

}
