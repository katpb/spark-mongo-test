import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.clustering.KMeans;
import org.apache.spark.ml.clustering.KMeansModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class Main7 {
	
	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		
		Dataset<Row> rawData = SparkConnection.getSession().read().option("header", "true").option("inferSchema", "true").format("csv").load(SparkConnection.CUSTOMERS_DATA_FILE);
		
		Dataset<Row> featuresDF = rawData.select("Channel", "Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen");
		VectorAssembler assembler = new VectorAssembler().setInputCols(new String[] {"Channel", "Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen"}).setOutputCol("features");
		
		Dataset<Row> trainingData = assembler.transform(featuresDF).select("features");
		
		KMeans kMeans = new KMeans().setK(3);
		KMeansModel model = kMeans.fit(trainingData);
		System.out.println(model.computeCost(trainingData));
		model.summary().predictions().show();
	}

}
