package learn.spark;

import java.util.ArrayList;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkJavaHelloWorld {

	public static void main(String[] args) {
//		System.setProperty("hadoop.home.dir", "D:\\Softwares\\hadoop\\");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		SparkConf sparkConf = new SparkConf().setAppName("spark2.4-test").setMaster("local");
//		SparkConf sparkConf = new SparkConf().setAppName("spark2.4-test").setMaster("local").set("spark.testing.memory", "2147480000");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		JavaRDD<Integer> dataRDD = sc.parallelize(list);
		dataRDD.collect().forEach(n -> System.out.println(n));
		sc.close();
	}

}
