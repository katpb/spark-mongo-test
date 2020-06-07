
import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public final class JavaWordCount {
	private static final Pattern SPACE = Pattern.compile(" ");
	private static final String fileName = "F:\\Program_Files\\learning\\spark-master\\examples\\src\\main\\resources\\people.txt";
	public static void main(String[] args) throws Exception {
		  SparkConf sparkConf = new SparkConf();
		  
			sparkConf.setAppName("JavaWordCount");
			//sparkConf.setMaster("local");
			sparkConf.setMaster("spark://192.168.0.104:7077");
			

			JavaSparkContext context = new JavaSparkContext(sparkConf);
		

		//SparkSession spark = SparkSession.builder().appName("JavaWordCount").getOrCreate();

		JavaRDD<String> lines = context.textFile(fileName);

		JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());
//		 JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

			/**
			 * 
			 */
//			private static final long serialVersionUID = 5505610053679929533L;
//
//			@Override
//			public Iterator<String> call(String s) throws Exception {
//				 return Arrays.asList(SPACE.split(s)).iterator();
//			}
//		});
		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));
//		 JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -7255094279990740173L;
//
//			@Override
//			public Tuple2<String, Integer> call(String s) throws Exception {
//				
//				return new Tuple2<String, Integer>(s, 1);
//			}
//		});
//		 
		JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);
//
//		 JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
//			
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -6748242685259926929L;
//
//			@Override
//			public Integer call(Integer arg0, Integer arg1) throws Exception {
//				return arg0 + arg1;
//			}
//		});
//		 
System.out.println("Count is empty :" + counts.isEmpty());
//		List<Tuple2<String, Integer>> output = counts.collect();
//		for (Tuple2<?, ?> tuple : output) {
//			System.out.println(tuple._1() + ": " + tuple._2());
//		}
//		
		context.close();
	}
}
